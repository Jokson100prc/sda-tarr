package programowanie_zaawansowane.c4_yaml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class YamlDemo {
  public static void main(String[] args) {
    String pathStr = "src\\main\\java\\programowanie_zaawansowane\\c4_yaml\\configuration.yaml";
    DumperOptions options = new DumperOptions();
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    options.setPrettyFlow(true);
    Yaml yaml = new Yaml(options);
    try(InputStream in = Files.newInputStream(Paths.get(pathStr))) {
      Configuration config = yaml.loadAs(in, Configuration.class);
      //System.out.println( config.toString() );
      System.out.println(yaml.dump(config));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
