package com.farshatov.feature_sports

import com.farshatov.common.network.Result
import com.farshatov.feature_sports.data.repository.SportsRepositoryImpl
import com.farshatov.feature_sports.domain.usecase.GetSportsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GetSportsUseCaseTest {
    val repository = mockk<SportsRepositoryImpl>() {
        coEvery { fetchSports() } returns flow {
            emit(Result.Success(data = Generator.sportsModel))
        }
    }

    val usecase = GetSportsUseCase(repository)

    @Test
    fun `when process fetchSports`() {
        // Given
        val checkedSportsModel = Generator.sportsModel
        runBlocking {
            // When
            val sports = usecase.invoke().collect {
                // Then
                MatcherAssert.assertThat(it.data, equalTo(checkedSportsModel))
            }
        }
    }
}
