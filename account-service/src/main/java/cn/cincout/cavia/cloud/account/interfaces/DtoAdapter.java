package cn.cincout.cavia.cloud.account.interfaces;

import cn.cincout.cavia.cloud.account.api.dto.account.AccountDto;
import cn.cincout.cavia.cloud.account.api.dto.order.OrderDetailDto;
import cn.cincout.cavia.cloud.account.api.dto.price.PriceStandardDto;
import cn.cincout.cavia.cloud.account.api.dto.resource.ResourceDto;
import cn.cincout.cavia.cloud.account.domain.account.Account;
import cn.cincout.cavia.cloud.account.domain.order.OrderDetail;
import cn.cincout.cavia.cloud.account.domain.price.PriceStandard;
import cn.cincout.cavia.cloud.account.domain.resource.Resource;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-9
 * @sine 1.8
 */
public abstract class DtoAdapter {
    private DtoAdapter() {}

    public static AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        return accountDto;
    }

    public static Account toDomain(AccountDto dto) {
        if (dto == null) {
            return null;
        }
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        return account;
    }

    public static List<AccountDto> toAccountDtoList(List<Account> accounts) {
        if (accounts == null) {
            return null;
        }
        List<AccountDto> accountDtoList = new ArrayList<>();
        accounts.stream().forEach(account -> accountDtoList.add(toDto(account)));
        return accountDtoList;
    }

    public static OrderDetailDto toDto(OrderDetail orderDetail) {
        if (orderDetail == null) {
            return null;
        }
        OrderDetailDto detailDto = new OrderDetailDto();
        BeanUtils.copyProperties(orderDetail, detailDto);
        return detailDto;
    }

    public static OrderDetail toDomain(OrderDetailDto orderDetailDto) {
        if (orderDetailDto == null) {
            return null;
        }
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(orderDetailDto, orderDetail);
        return orderDetail;
    }

    public static List<OrderDetailDto> toOrderDtoList(List<OrderDetail> orderDetails) {
        if (orderDetails == null) {
            return null;
        }
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        orderDetails.stream().forEach(orderDetail -> orderDetailDtoList.add(toDto(orderDetail)));
        return orderDetailDtoList;
    }

    public static PriceStandard toDomain(PriceStandardDto dto) {
        if (dto == null) {
            return null;
        }
        PriceStandard priceStandard = new PriceStandard();
        BeanUtils.copyProperties(dto, priceStandard);
        return priceStandard;
    }

    public static PriceStandardDto toDto(PriceStandard priceStandard) {
        if (priceStandard == null) {
            return null;
        }
        PriceStandardDto dto = new PriceStandardDto();
        BeanUtils.copyProperties(priceStandard, dto);
        return dto;
    }

    public static Collection<PriceStandardDto> toPriceStandardDtoList(Collection<PriceStandard> priceStandards) {
        if (priceStandards == null) {
            return null;
        }
        Collection<PriceStandardDto> priceStandardDtoList = new ArrayList<>();
        priceStandards.stream().forEach(priceStandard -> priceStandardDtoList.add(toDto(priceStandard)));
        return priceStandardDtoList;
    }

    public static Collection<PriceStandard> toPriceStandardDomainList(Collection<PriceStandardDto> collections) {
        if (collections == null) {
            return null;
        }
        Collection<PriceStandard> priceStandards = new ArrayList<>();
        collections.stream().forEach(priceStandardDto -> priceStandards.add(toDomain(priceStandardDto)));
        return priceStandards;
    }

    // resource
    public static Resource toDomain(ResourceDto dto) {
        if (dto == null) {
            return null;
        }
        Resource resource = new Resource();
        BeanUtils.copyProperties(dto, resource);
        return resource;
    }

    public static ResourceDto toDto(Resource resource) {
        if (resource == null) {
            return null;
        }
        ResourceDto resourceDto = new ResourceDto();
        BeanUtils.copyProperties(resource, resourceDto);
        return resourceDto;
    }

    public static List<Resource> toResourceList(List<ResourceDto> resourceDtoList) {
        if (resourceDtoList == null) {
            return null;
        }
        List<Resource> resources = new ArrayList<>();
        resourceDtoList.stream().forEach(resourceDto -> resources.add(toDomain(resourceDto)));
        return resources;
    }

    public static List<ResourceDto> toResourceDtoList(List<Resource> resources) {
        if (resources == null) {
            return null;
        }
        List<ResourceDto> resourceDtoList = new ArrayList<>();
        resources.stream().forEach(resource -> resourceDtoList.add(toDto(resource)));
        return resourceDtoList;
    }
}
