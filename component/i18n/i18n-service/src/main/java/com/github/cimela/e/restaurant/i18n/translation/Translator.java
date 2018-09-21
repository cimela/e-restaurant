package com.github.cimela.e.restaurant.i18n.translation;

import com.github.cimela.e.restaurant.base.common.Item;

public interface Translator<T> extends Item {
    Object translate(T object);
}
