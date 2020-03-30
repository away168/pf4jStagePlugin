package io.armory.plugin.stage.pagerduty

import com.netflix.spinnaker.orca.api.simplestage.SimpleStage
import com.netflix.spinnaker.orca.api.simplestage.SimpleStageInput
import com.netflix.spinnaker.orca.api.simplestage.SimpleStageOutput
import com.netflix.spinnaker.orca.api.simplestage.SimpleStageStatus
import org.slf4j.LoggerFactory
import org.pf4j.Extension
import org.pf4j.Plugin
import org.pf4j.PluginWrapper
import java.util.concurrent.TimeUnit
import java.util.*


class PagerDutyPlugin(wrapper: PluginWrapper) : Plugin(wrapper) {
    private val logger = LoggerFactory.getLogger(PagerDutyPlugin::class.java)

    // lifecycle hook - called when plugin gets loaded
    // something might be useful is to do a sanity check - no way to get configs though
    // future: may add more lifecycle hooks: verify / healthcheck
    override fun start() {
        logger.info("PagerDutyPlugin.start()")
    }

    // lifecycle hook - when gracefully shutdown by orca
    // nothing really happens here other than logging
    override fun stop() {
        logger.info("PagerDutyPlugin.stop()")
    }
}

/**
 * Example stage that implements the Orca API Stage interface. By implementing Stage,
 * your stage is available for use in Spinnaker.
 */
@Extension  // REQUIRED.
class PagerDutyStage(private val configuration: Config) : SimpleStage<Input> {

    private val log = LoggerFactory.getLogger(PagerDutyStage::class.java)

    /**
     * This sets the name of the stage
     * @return the name of the stage
     */
    override fun getName(): String {
        return "pagerDuty"
    }

    /**
     * This is what gets ran when the stage is executed. It takes in an object that you create. That
     * object contains fields that one wishes to pull out of the pipeline context. This gives us a
     * strongly typed object that you have full control over. The function returns a SimpleStageOutput object.
     * The SimpleStageOutput class contains the status of the stage and any stage outputs that should be
     * put back into the pipeline context.
     * @param stageInput<RandomWaitInput>
     * @return the status of the stage and any context that should be passed to the pipeline context
    </RandomWaitInput> */
    override fun execute(stageInput: SimpleStageInput<Input>): SimpleStageOutput<*, *> {
//        val rand = Random()
        val url = configuration.url
        val query = stageInput.value.query
//        val timeToWait = rand.nextInt(maxWaitTime)

//        try {
//            TimeUnit.SECONDS.sleep(timeToWait.toLong())
//        } catch (e: Exception) {
//            log.error("{}", e)
//        }

        val stageOutput = SimpleStageOutput<Output, Context>()
        val output = Output(true)
        val context = Context(url + "  " + query)

        stageOutput.setOutput(output)
        stageOutput.setContext(context)
        stageOutput.setStatus(SimpleStageStatus.SUCCEEDED)

        return stageOutput
    }
}
