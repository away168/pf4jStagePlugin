package io.armory.plugin.stage.wait.random

import com.netflix.spinnaker.kork.plugins.api.ExtensionConfiguration

// REQUIRED - the value tells where to populate from...
@ExtensionConfiguration("armory.randomWaitStage")
data class RandomWaitConfig(var defaultMaxWaitTime: Int)
