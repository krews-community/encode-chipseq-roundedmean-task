import org.junit.jupiter.api.*
import step.*
import testutil.*
import testutil.cmdRunner
import java.nio.file.*
import org.assertj.core.api.Assertions.*

class RoundedmeanTests {
    @BeforeEach fun setup() = setupTest()
    @AfterEach fun cleanup() = cleanupTest()

     @Test fun `run roundedmean step  `() {
         var taFiles = mutableListOf<Path>()
         taFiles.add(f1)
         taFiles.add(f2)
         val fl1 = java.io.File(f1.toString()).readText(Charsets.UTF_8).trim().toInt()
         val fl2 = java.io.File(f2.toString()).readText(Charsets.UTF_8).trim().toInt()

         cmdRunner.roundedMean(taFiles, testOutputDir,"roundedmean")
         assertThat(testOutputDir.resolve("roundedmean.txt")).exists()
         val rounded_mean = java.io.File(testOutputDir.resolve("roundedmean.txt").toString()).readText(Charsets.UTF_8).trim().toInt()
         assertThat((Math.round((fl1+fl2).div(2.toFloat())))).isEqualTo(rounded_mean)
     }

}