package id.android.bootcamp

import id.android.bootcamp.ui.RaceParticipant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RaceParticipantTest {

  private val raceParticipant = RaceParticipant(
    name = "Test",
    maxProgress = 100,
    progressDelayMillis = 500L,
    initialProgress = 0,
    progressIncrement = 1
  )

  @Test
  fun raceParticipant_RaceStarted_ProgressUpdated() = runTest {
    val expectedProgress = 1
    launch { raceParticipant.run() }
    advanceTimeBy(raceParticipant.progressDelayMillis)
    runCurrent()
    assertEquals(expectedProgress, raceParticipant.currentProgress)
  }

  @Test
  fun raceParticipant_RaceFinished_ProgressUpdated() = runTest {
    launch { raceParticipant.run() }
    advanceTimeBy(raceParticipant.maxProgress * raceParticipant.progressDelayMillis)
    runCurrent()
    assertEquals(100, raceParticipant.currentProgress)
  }
}