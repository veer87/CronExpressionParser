package com.Api.ResponseMapper;

import java.util.List;
import java.util.Map;

public class CronParserResponse implements Response{

    @Override
    public Object build(Map<String, List<String>> context) {
        StringBuilder response = new StringBuilder();
        for(Map.Entry<String, List<String>> entry : context.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();

            if (key != null && value != null) {
                response.append(key).append(": ").append(String.join(" ", value)).append("\n");
            }
        }

        return response.toString();

    }
}
