/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

class JourneyPlannerSpec extends AnyWordSpec with Matchers {

  "stations" should {
    "be initialized correctly" in {
      planner.stations shouldEqual Set(munich, nuremberg, cologne, essen)
    }
  }
}
