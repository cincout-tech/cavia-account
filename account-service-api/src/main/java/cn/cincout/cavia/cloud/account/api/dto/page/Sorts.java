package cn.cincout.cavia.cloud.account.api.dto.page;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public class Sorts implements Iterable<Sorts.OrderBy>, Serializable {

    public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private List<OrderBy> orders;

    public Sorts() {
        this.orders = null;
    }

    /**
     * Creates a new {@link Sorts} instance using the given {@link OrderBy}s.
     *
     * @param orders must not be {@literal null}.
     */
    public Sorts(OrderBy... orders) {
        this(Arrays.asList(orders));
    }

    /**
     * Creates a new {@link Sorts} instance.
     *
     * @param orders must not be {@literal null} or contain {@literal null}.
     */
    public Sorts(List<OrderBy> orders) {

        if (null == orders || orders.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }

        this.orders = orders;
    }

    /**
     * Creates a new {@link Sorts} instance. Order defaults to {@value Direction#ASC}.
     *
     * @param properties must not be {@literal null} or contain {@literal null} or empty strings
     */
    public Sorts(String... properties) {
        this(DEFAULT_DIRECTION, properties);
    }

    /**
     * Creates a new {@link Sorts} instance.
     *
     * @param direction defaults to {@linke Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties must not be {@literal null}, empty or contain {@literal null} or empty strings.
     */
    public Sorts(Direction direction, String... properties) {
        this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
    }

    /**
     * Creates a new {@link Sorts} instance.
     *
     * @param direction defaults to {@linke Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties must not be {@literal null} or contain {@literal null} or empty strings.
     */
    public Sorts(Direction direction, List<String> properties) {

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        this.orders = new ArrayList<OrderBy>(properties.size());

        for (String property : properties) {
            this.orders.add(new OrderBy(direction, property));
        }
    }

    /**
     * Returns a new {@link Sorts} consisting of the {@link OrderBy}s of the current {@link Sorts} combined with the given
     * ones.
     *
     * @param sort can be {@literal null}.
     * @return
     */
    public Sorts and(Sorts sort) {

        if (sort == null) {
            return this;
        }

        ArrayList<OrderBy> these = new ArrayList<OrderBy>(this.orders);

        for (OrderBy order : sort) {
            these.add(order);
        }

        return new Sorts(these);
    }

    /**
     * Returns the order registered for the given property.
     *
     * @param property
     * @return
     */
    public OrderBy getOrderFor(String property) {

        for (OrderBy order : this) {
            if (order.getProperty().equals(property)) {
                return order;
            }
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<OrderBy> iterator() {
        return this.orders.iterator();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Sorts)) {
            return false;
        }

        Sorts that = (Sorts) obj;

        return this.orders.equals(that.orders);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;
        result = 31 * result + orders.hashCode();
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return StringUtils.join(orders);
    }

    /**
     * Enumeration for sort directions.
     *
     * @author Oliver Gierke
     */
    public static enum Direction {

        ASC, DESC;

        /**
         * Returns whether the direction is ascending.
         *
         * @return
         * @since 1.13
         */
        public boolean isAscending() {
            return this.equals(ASC);
        }

        /**
         * Returns whether the direction is descending.
         *
         * @return
         * @since 1.13
         */
        public boolean isDescending() {
            return this.equals(DESC);
        }

        /**
         * Returns the {@link Direction} enum for the given {@link String} value.
         *
         * @param value
         * @throws IllegalArgumentException in case the given value cannot be parsed into an enum value.
         * @return
         */
        public static Direction fromString(String value) {

            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format(
                        "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }

        /**
         * Returns the {@link Direction} enum for the given {@link String} or null if it cannot be parsed into an enum
         * value.
         *
         * @param value
         * @return
         */
        public static Direction fromStringOrNull(String value) {

            try {
                return fromString(value);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    /**
     * Enumeration for null handling hints that can be used in {@link OrderBy} expressions.
     *
     * @author Thomas Darimont
     * @since 1.8
     */
    public static enum NullHandling {

        /**
         * Lets the data store decide what to do with nulls.
         */
        NATIVE,

        /**
         * A hint to the used data store to order entries with null values before non null entries.
         */
        NULLS_FIRST,

        /**
         * A hint to the used data store to order entries with null values after non null entries.
         */
        NULLS_LAST;
    }

    /**
     * PropertyPath implements the pairing of an {@link Direction} and a property. It is used to provide input for
     * {@link Sorts}
     *
     * @author Oliver Gierke
     * @author Kevin Raymond
     */
    public static class OrderBy implements Serializable {
        private static final boolean DEFAULT_IGNORE_CASE = false;

        private  Direction direction;
        private  String property;
        private  boolean ignoreCase;
        private  NullHandling nullHandling;

        public OrderBy() {
        }

        /**
         * Creates a new {@link OrderBy} instance. if order is {@literal null} then order defaults to
         * {@link Sorts#DEFAULT_DIRECTION}
         *
         * @param direction can be {@literal null}, will default to {@link Sorts#DEFAULT_DIRECTION}
         * @param property must not be {@literal null} or empty.
         */
        public OrderBy(Direction direction, String property) {
            this(direction, property, DEFAULT_IGNORE_CASE, null);
        }

        /**
         * Creates a new {@link OrderBy} instance. if order is {@literal null} then order defaults to
         * {@link Sorts#DEFAULT_DIRECTION}
         *
         * @param direction can be {@literal null}, will default to {@link Sorts#DEFAULT_DIRECTION}
         * @param property must not be {@literal null} or empty.
         * @param nullHandlingHint can be {@literal null}, will default to {@link NullHandling#NATIVE}.
         */
        public OrderBy(Direction direction, String property, NullHandling nullHandlingHint) {
            this(direction, property, DEFAULT_IGNORE_CASE, nullHandlingHint);
        }

        /**
         * Creates a new {@link OrderBy} instance. Takes a single property. Direction defaults to
         * {@link Sorts#DEFAULT_DIRECTION}.
         *
         * @param property must not be {@literal null} or empty.
         */
        public OrderBy(String property) {
            this(DEFAULT_DIRECTION, property);
        }

        /**
         * Creates a new {@link OrderBy} instance. if order is {@literal null} then order defaults to
         * {@link Sorts#DEFAULT_DIRECTION}
         *
         * @param direction can be {@literal null}, will default to {@link Sorts#DEFAULT_DIRECTION}
         * @param property must not be {@literal null} or empty.
         * @param ignoreCase true if sorting should be case insensitive. false if sorting should be case sensitive.
         * @param nullHandling can be {@literal null}, will default to {@link NullHandling#NATIVE}.
         * @since 1.7
         */
        private OrderBy(Direction direction, String property, boolean ignoreCase, NullHandling nullHandling) {

            if (StringUtils.isBlank(property)) {
                throw new IllegalArgumentException("Property must not null or empty!");
            }

            this.direction = direction == null ? DEFAULT_DIRECTION : direction;
            this.property = property;
            this.ignoreCase = ignoreCase;
            this.nullHandling = nullHandling == null ? NullHandling.NATIVE : nullHandling;
        }

        /**
         * Returns the order the property shall be sorted for.
         *
         * @return
         */
        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public void setIgnoreCase(boolean ignoreCase) {
            this.ignoreCase = ignoreCase;
        }

        public void setNullHandling(NullHandling nullHandling) {
            this.nullHandling = nullHandling;
        }

        /**
         * Returns the property to order for.
         *
         * @return
         */
        public String getProperty() {
            return property;
        }

        /**
         * Returns whether sorting for this property shall be ascending.
         *
         * @return
         */
        public boolean isAscending() {
            return this.direction.isAscending();
        }

        /**
         * Returns whether sorting for this property shall be descending.
         *
         * @return
         * @since 1.13
         */
        public boolean isDescending() {
            return this.direction.isDescending();
        }

        /**
         * Returns whether or not the sort will be case sensitive.
         *
         * @return
         */
        public boolean isIgnoreCase() {
            return ignoreCase;
        }

        /**
         * Returns a new {@link OrderBy} with the given {@link Direction}.
         *
         * @param direction
         * @return
         */
        public OrderBy with(Direction direction) {
            return new OrderBy(direction, this.property, this.ignoreCase, this.nullHandling);
        }

        /**
         * Returns a new {@link OrderBy}
         *
         * @param property must not be {@literal null} or empty.
         * @return
         * @since 1.13
         */
        public OrderBy withProperty(String property) {
            return new OrderBy(this.direction, property, this.ignoreCase, this.nullHandling);
        }

        /**
         * Returns a new {@link Sorts} instance for the given properties.
         *
         * @param properties
         * @return
         */
        public Sorts withProperties(String... properties) {
            return new Sorts(this.direction, properties);
        }

        /**
         * Returns a new {@link OrderBy} with case insensitive sorting enabled.
         *
         * @return
         */
        public OrderBy ignoreCase() {
            return new OrderBy(direction, property, true, nullHandling);
        }

        /**
         * Returns a {@link OrderBy} with the given {@link NullHandling}.
         *
         * @param nullHandling can be {@literal null}.
         * @return
         * @since 1.8
         */
        public OrderBy with(NullHandling nullHandling) {
            return new OrderBy(direction, this.property, ignoreCase, nullHandling);
        }

        /**
         * Returns a {@link OrderBy} with {@link NullHandling#NULLS_FIRST} as null handling hint.
         *
         * @return
         * @since 1.8
         */
        public OrderBy nullsFirst() {
            return with(NullHandling.NULLS_FIRST);
        }

        /**
         * Returns a {@link OrderBy} with {@link NullHandling#NULLS_LAST} as null handling hint.
         *
         * @return
         * @since 1.7
         */
        public OrderBy nullsLast() {
            return with(NullHandling.NULLS_LAST);
        }

        /**
         * Returns a {@link OrderBy} with {@link NullHandling#NATIVE} as null handling hint.
         *
         * @return
         * @since 1.7
         */
        public OrderBy nullsNative() {
            return with(NullHandling.NATIVE);
        }

        /**
         * Returns the used {@link NullHandling} hint, which can but may not be respected by the used datastore.
         *
         * @return
         * @since 1.7
         */
        public NullHandling getNullHandling() {
            return nullHandling;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {

            int result = 17;

            result = 31 * result + direction.hashCode();
            result = 31 * result + property.hashCode();
            result = 31 * result + (ignoreCase ? 1 : 0);
            result = 31 * result + nullHandling.hashCode();

            return result;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof OrderBy)) {
                return false;
            }

            OrderBy that = (OrderBy) obj;

            return this.direction.equals(that.direction) && this.property.equals(that.property)
                    && this.ignoreCase == that.ignoreCase && this.nullHandling.equals(that.nullHandling);
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {

            String result = String.format("%s: %s", property, direction);

            if (!NullHandling.NATIVE.equals(nullHandling)) {
                result += ", " + nullHandling;
            }

            if (ignoreCase) {
                result += ", ignoring case";
            }

            return result;
        }
    }
}
