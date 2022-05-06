package io.sutsaehpeh.aqbp.common.util;

import cn.hutool.core.collection.CollectionUtil;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathBuilder;
import io.sutsaehpeh.aqbp.common.page.Direction;

import java.util.ArrayList;
import java.util.List;

public class QuerydslOrderUtil {

    private QuerydslOrderUtil() {
    }

    public static <T> List<OrderSpecifier<?>> getSortColumnList(EntityPathBase<T> base, String direction, List<String> sortBy) {
        List<OrderSpecifier<?>> specifiers = new ArrayList<>();
        if (CollectionUtil.isEmpty(sortBy)) {
            return specifiers;
        }
        for (String sort : sortBy) {
            specifiers.add(getSortColumn(base, direction, sort));
        }
        return specifiers;
    }

    public static <T> OrderSpecifier<?> getSortColumn(EntityPathBase<T> base, String direction, String sortField) {
        Order order = Direction.ASC.getDirection().equalsIgnoreCase(direction) ? Order.ASC : Order.DESC;
        PathBuilder builder = new PathBuilder<T>((Class<? extends T>) Object.class, base.getMetadata());
        return new OrderSpecifier<>(order, builder.get(sortField));
    }

    public static <T> OrderSpecifier<?> getSortColumn(EntityPathBase<T> base, String sortField) {
        PathBuilder builder = new PathBuilder<T>((Class<? extends T>) Object.class, base.getMetadata());
        return new OrderSpecifier<>(Order.DESC, builder.get(sortField));
    }
}
