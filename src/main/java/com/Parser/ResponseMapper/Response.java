package com.Api.ResponseMapper;

import java.util.List;
import java.util.Map;

public interface Response {
    Object build(Map<String, List<String>> context);
}
