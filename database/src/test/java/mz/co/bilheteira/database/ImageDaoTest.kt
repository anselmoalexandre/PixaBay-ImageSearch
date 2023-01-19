package mz.co.bilheteira.database

import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import mz.co.bilheteira.database.dao.ImageDao
import mz.co.bilheteira.database.entity.ImageEntity
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ImageDaoTest {
    private lateinit var imageEntity: ImageEntity

    @MockK
    private lateinit var imageDao: ImageDao

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        imageEntity = ImageEntity(
            id = 1,
            user = "User",
            likes = 100,
            downloads = 1000,
            comments = 10,
            tags = "fruits, apple",
            previewURL = "applePreviewURL",
            largeImageURL = "largePreviewURL"
        )

        coJustRun { imageDao.insertImageDetails(imageEntity) }
    }

    @Test
    fun `insert or update image details`() = runTest {
        // When
        imageDao.insertImageDetails(imageEntity)

        // Then
        coVerify { imageDao.insertImageDetails(imageEntity) }
    }

    @Test
    fun `get all cached image details`() = runTest {
        // Given
        coEvery { imageDao.getImagesDetails() } returns listOf(imageEntity)

        // When
        val listOfImagesDetails = imageDao.getImagesDetails()

        // Then
        assertThat(listOfImagesDetails).isNotEmpty()
    }

    @Test
    fun `get cached image details by id`() = runTest {
        // Given
        val listOfImages = listOf(
            ImageEntity(
                id = 1000,
                user = "User",
                likes = 100,
                downloads = 1000,
                comments = 10,
                tags = "fruits, apple",
                previewURL = "applePreviewURL",
                largeImageURL = "largePreviewURL"
            ),
            ImageEntity(
                id = 1001,
                user = "User",
                likes = 100,
                downloads = 1000,
                comments = 10,
                tags = "fruits, apple",
                previewURL = "applePreviewURL",
                largeImageURL = "largePreviewURL"
            ),
            ImageEntity(
                id = 1002,
                user = "User",
                likes = 100,
                downloads = 1000,
                comments = 10,
                tags = "fruits, apple",
                previewURL = "applePreviewURL",
                largeImageURL = "largePreviewURL"
            )
        )

        coEvery {
            imageDao.getImageDetails(1001)
        } returns ImageEntity(
            id = 1001,
            user = "User",
            likes = 100,
            downloads = 1000,
            comments = 10,
            tags = "fruits, apple",
            previewURL = "applePreviewURL",
            largeImageURL = "largePreviewURL"
        )

        // When
        val imageDetailsById = imageDao.getImageDetails(1001)

        // Then
        assertThat(imageDetailsById.id).isEqualTo(1001)
    }
}