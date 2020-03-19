package io.armory.plugin.stage.pagerduty

import com.netflix.spinnaker.kork.plugins.api.ExtensionConfiguration

// REQUIRED - the value tells where to populate configurations from... in the .hal/config file
@ExtensionConfiguration("armory.pagerDutyStage")
data class Config(var url: String)
