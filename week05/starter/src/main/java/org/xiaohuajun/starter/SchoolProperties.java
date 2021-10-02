package org.xiaohuajun.starter;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2021/9/5 上午7:44
 * @description SchoolProperties
 */
@ConfigurationProperties(prefix = "school")
@Data
public class SchoolProperties {
  private List<Integer> studentIds;
  private List<String> studentNames;
  private List<Integer> myClassIds;
  private List<String> myClassNames;
  private List<Map<String, Integer>> studentOfClass;
}
