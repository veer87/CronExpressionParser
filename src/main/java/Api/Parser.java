package Api;

import java.util.List;
import java.util.Map;

public interface Parser {
    Object parse(String exp) throws Exception;
}
