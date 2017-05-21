package cn.cincout.cavia.cloud.account.interfaces.utils;

import cn.cincout.cavia.cloud.account.api.dto.page.Sorts;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-5-15
 * @sine 1.8
 */
public class PageUtils {
    private PageUtils() {}

    public static Sort toSort(Sorts sorts) {
        if (sorts == null) {
            return null;
        }
        List<Sort.Order> orderList = new ArrayList<>();
        sorts.forEach(orderBy -> {
            orderList.add(new Sort.Order(orderBy.getDirection().isAscending()? Sort.Direction.ASC : Sort.Direction.DESC, orderBy.getProperty()));
        });
        return new Sort(orderList);
    }
}
