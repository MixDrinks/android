package org.mixdrinks.mixdrinks.features.data

import com.google.gson.GsonBuilder
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailProvider {
    @GET("search/cocktails")
    suspend fun getCocktails(@Query("page") p: Int): CocktailsResponse
}


object CocktailProviderMock {
    private val jsonString = """{
    "id": 1,
    "name": "50 відтінків улуну",
    "visitCount": 128,
    "rating": 5.0,
    "ratingCount": 2,
    "receipt": [
        "Налий у шейкер сік з лимонів гриль 15 мл, грейпфрутовий сік 15 мл, цукровий сироп 22.5 мл і домашній джин на улуні 60 мл",
        "Додай лимонний бітер 2 деш",
        "Наповни шейкер кубиками льоду та збий",
        "Перелий через стрейнер та ситечко в коктейльний келих",
        "Прикрась сушеною чайною квіткою"
    ],
    "images": [
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/origin/1.webp",
            "media": "screen and (min-width: 570px)",
            "type": "image/webp"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/560/1.webp",
            "media": "screen and (min-width: 410px)",
            "type": "image/webp"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/400/1.webp",
            "media": "screen and (min-width: 330px)",
            "type": "image/webp"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/320/1.webp",
            "media": "screen and (min-width: 0px)",
            "type": "image/webp"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/origin/1.jpg",
            "media": "screen and (min-width: 570px)",
            "type": "image/jpg"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/560/1.jpg",
            "media": "screen and (min-width: 410px)",
            "type": "image/jpg"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/400/1.jpg",
            "media": "screen and (min-width: 330px)",
            "type": "image/jpg"
        },
        {
            "srcset": "https://image.mixdrinks.org/cocktails/1/320/1.jpg",
            "media": "screen and (min-width: 0px)",
            "type": "image/jpg"
        }
    ],
    "goods": [
        {
            "id": 128,
            "name": "Сухі квітки для чаю",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/origin/128.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/560/128.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/400/128.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/320/128.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/origin/128.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/560/128.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/400/128.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/128/320/128.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 1,
            "unit": "шт"
        },
        {
            "id": 210,
            "name": "Домашній джин на улуні",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/origin/210.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/560/210.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/400/210.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/320/210.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/origin/210.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/560/210.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/400/210.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/210/320/210.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 60,
            "unit": "мл"
        },
        {
            "id": 431,
            "name": "Лід в кубиках",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/origin/431.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/560/431.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/400/431.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/320/431.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/origin/431.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/560/431.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/400/431.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/431/320/431.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 200,
            "unit": "г"
        },
        {
            "id": 433,
            "name": "Грейпфрутовий сік",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/origin/433.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/560/433.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/400/433.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/320/433.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/origin/433.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/560/433.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/400/433.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/433/320/433.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 15,
            "unit": "мл"
        },
        {
            "id": 439,
            "name": "Сік з лимонів-гриль",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/origin/439.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/560/439.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/400/439.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/320/439.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/origin/439.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/560/439.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/400/439.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/439/320/439.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 15,
            "unit": "мл"
        },
        {
            "id": 473,
            "name": "Лимонний бітер",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/origin/473.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/560/473.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/400/473.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/320/473.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/origin/473.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/560/473.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/400/473.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/473/320/473.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 2,
            "unit": "мл"
        },
        {
            "id": 588,
            "name": "Цукровий сироп",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/origin/588.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/560/588.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/400/588.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/320/588.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/origin/588.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/560/588.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/400/588.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/588/320/588.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 22,
            "unit": "мл"
        }
    ],
    "tools": [
        {
            "id": 14,
            "name": "Стрейнер",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/origin/14.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/560/14.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/400/14.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/320/14.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/origin/14.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/560/14.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/400/14.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/14/320/14.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 1,
            "unit": "шт"
        },
        {
            "id": 323,
            "name": "Коктейльний келих",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/origin/323.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/560/323.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/400/323.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/320/323.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/origin/323.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/560/323.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/400/323.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/323/320/323.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 1,
            "unit": "шт"
        },
        {
            "id": 468,
            "name": "Шейкер",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/origin/468.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/560/468.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/400/468.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/320/468.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/origin/468.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/560/468.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/400/468.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/468/320/468.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 1,
            "unit": "шт"
        },
        {
            "id": 85,
            "name": "Джигер",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/origin/85.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/560/85.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/400/85.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/320/85.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/origin/85.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/560/85.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/400/85.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/85/320/85.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 1,
            "unit": "шт"
        },
        {
            "id": 62,
            "name": "Ситечко",
            "images": [
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/origin/62.webp",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/560/62.webp",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/400/62.webp",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/320/62.webp",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/webp"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/origin/62.jpg",
                    "media": "screen and (min-width: 570px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/560/62.jpg",
                    "media": "screen and (min-width: 410px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/400/62.jpg",
                    "media": "screen and (min-width: 330px)",
                    "type": "image/jpg"
                },
                {
                    "srcset": "https://image.mixdrinks.org/goods/62/320/62.jpg",
                    "media": "screen and (min-width: 0px)",
                    "type": "image/jpg"
                }
            ],
            "amount": 1,
            "unit": "шт"
        }
    ],
    "tags": [
        {
            "id": 6,
            "name": "міцні"
        },
        {
            "id": 7,
            "name": "кислі"
        },
        {
            "id": 16,
            "name": "цитрусові"
        },
        {
            "id": 17,
            "name": "на джині"
        },
        {
            "id": 18,
            "name": "шорти"
        }
    ]
}
"""
    fun get(): DetailCocktailResponse {
        val gson = GsonBuilder().setLenient().create()
        return gson.fromJson(jsonString, DetailCocktailResponse::class.java)
    }
}