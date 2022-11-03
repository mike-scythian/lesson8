package nix.lessons;

import static org.assertj.core.api.Assertions.assertThat;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private static Computer comp1;
    private static Computer comp2;
    private static Computer comp3;

    @BeforeAll
    public static void init(){

        comp1 = new Computer(32, 8, "MacBook Pro", OperatingSystem.MacOS);
        comp2 = Computer.builder()
                                    .ram(8)
                                    .cores(4)
                                    .name("Asus")
                                    .operatingSystem(OperatingSystem.Windows)
                                    .build();
        comp3 = new Computer(1, 2, "Acer", OperatingSystem.Windows);
    }
    @Test
    void shouldBuildComputer(){

        assertThat(comp2).isNotNull();
    }
    @Test
    void shouldExistSummaryInfo(){

        JSONObject testJson = new JSONObject("{\"name\":\"Asus\",\"cores\":4,\"ram\":8,\"os\":\"Windows\"}");

        assertThat(comp2.summaryInfo().toString()).isEqualTo(testJson.toString());

    }
    @Test
    void tryIsWorkable(){

        assertThat(comp1.isWorkable()).isTrue();
        assertThat(comp2.isWorkable()).isTrue();
        assertThat(comp3.isWorkable()).isFalse();
    }
    @Test
    void shouldBeSpeedOfProcessing(){

        assertThat(comp3.speedOfProcessing(10000)).isZero();
        assertThat(comp2.speedOfProcessing(0)).isZero();
        assertThat(comp1.speedOfProcessing(2500)).isEqualTo(104);
        assertThat(comp2.speedOfProcessing(500)).isEqualTo(16000);
    }

}
