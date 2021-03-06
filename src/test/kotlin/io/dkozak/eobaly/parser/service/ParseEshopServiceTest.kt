package io.dkozak.eobaly.parser.service

import io.dkozak.eobaly.dao.*
import io.dkozak.eobaly.service.ParseEshopService
import io.dkozak.eobaly.tasks.EobalyParsingTask
import org.jsoup.Jsoup
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ParseEshopServiceTest {

    @Test
    fun `just parsing test`() {
        val doc = Jsoup.connect("https://www.eobaly.cz/produkty/kartonove-krabice.htm?page=2").get()
        val select = doc.select("a.pager-number")
        println(select.last().text())
    }

    private lateinit var eobalyParsingTask: EobalyParsingTask

    private lateinit var parseEshopService: ParseEshopService

    @Mock
    lateinit var productRepository: ProductRepository

    @Mock
    lateinit var productCategoryRepository: ProductCategoryRepository

    @Mock
    lateinit var productDetailsRepository: ProductDetailsRepository

    @Mock
    lateinit var errorLogRepository: ErrorLogRepository

    @Mock
    lateinit var productLogRepository: ProductLogRepository

    @Before
    fun init() {
        parseEshopService = ParseEshopService(productRepository, productDetailsRepository, productCategoryRepository, errorLogRepository, productLogRepository
        )
        eobalyParsingTask = EobalyParsingTask(parseEshopService, productRepository, errorLogRepository, productLogRepository)
    }

    @Test
    fun startParseTaskTest() {
        eobalyParsingTask.start()
    }

    @Test
    fun parseProduct() {
        val product = parseEshopService.parseProduct("https://www.eobaly.cz/papirova-civka-tvvysek-485x485x362-5vvl-vlna-bc.htm");

        println(product)
    }
}