package step
import mu.KotlinLogging
import util.*
import java.nio.file.*
import util.CmdRunner
private val log = KotlinLogging.logger {}

fun CmdRunner.roundedMean(taFiles:List<Path>,outDir:Path,outputPrefix:String) {
    log.info { "Make output Directory" }
    Files.createDirectories(outDir)
    val prefix = outDir.resolve(outputPrefix)
    val meanFile = "${prefix}.txt"
    var sum = 0
    taFiles.forEach {
        val s = java.io.File(it.toString()).readText(Charsets.UTF_8)
        val fl = s!!.trim().toInt()
        sum  += fl
    }
    val s =sum.div(taFiles.size.toFloat())

    val mean = Math.round(s)
    java.io.File(meanFile).writeText(mean.toString())

}
