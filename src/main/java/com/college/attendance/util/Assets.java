package com.college.attendance.util;

import com.college.attendance.response.CollageApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class Assets {


    public static String getOrDefault(String value, String defaultValue) {
        return StringUtils.hasText(value) ? value : defaultValue;
    }

    public static String getOrDefaultTwoLevel(String value, String defaultValue1, String defaultValue2) {
        return StringUtils.hasLength(value) ? value : getOrDefault(defaultValue1, defaultValue2);
    }

    public static <T>
    Stream<T> collectionToStream(Collection<T> collection) {
        return Optional.ofNullable(collection)
                .map(Collection::stream)
                .orElseGet(Stream::empty);
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList());
    }

    public <T> CollageApiResponse<T> generateResponseObj(int status,
                                                         String msg, T data) {
        CollageApiResponse<T> response = new CollageApiResponse<>();
        response.setStatus(status);
        response.setMessage(msg);
        response.setData(data);

        return response;

    }

}
