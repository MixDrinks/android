package org.mixdrinks.mixdrinks.features.data.filters

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("LargeClass")
class FilterProvider {
    class Filters : ArrayList<FilterItem>()

    private val jsonString = """[
    {
        "id": 4,
        "queryName": "alcoholVolume",
        "name": "Алкоголь",
        "items": [
            {
                "id": 6,
                "name": "міцні",
                "cocktailCount": 692
            },
            {
                "id": 1,
                "name": "слабоалкогольні",
                "cocktailCount": 275
            },
            {
                "id": 44,
                "name": "безалкогольні",
                "cocktailCount": 59
            }
        ],
        "selectionType": "SINGLE"
    },
    {
        "id": 3,
        "queryName": "taste",
        "name": "Смак",
        "items": [
            {
                "id": 12,
                "name": "солодкі",
                "cocktailCount": 549
            },
            {
                "id": 16,
                "name": "цитрусові",
                "cocktailCount": 339
            },
            {
                "id": 2,
                "name": "пряні",
                "cocktailCount": 236
            },
            {
                "id": 7,
                "name": "кислі",
                "cocktailCount": 234
            },
            {
                "id": 20,
                "name": "трав'яні",
                "cocktailCount": 163
            },
            {
                "id": 11,
                "name": "ягідні",
                "cocktailCount": 161
            },
            {
                "id": 8,
                "name": "фруктові",
                "cocktailCount": 100
            },
            {
                "id": 10,
                "name": "м'ятні",
                "cocktailCount": 58
            },
            {
                "id": 30,
                "name": "солоні",
                "cocktailCount": 34
            },
            {
                "id": 60,
                "name": "шоколадні",
                "cocktailCount": 21
            }
        ],
        "selectionType": "MULTIPLE"
    },
    {
        "id": 5,
        "queryName": "glassware",
        "name": "Стакан",
        "items": [
            {
                "id": 594,
                "name": "Рокс",
                "cocktailCount": 200
            },
            {
                "id": 74,
                "name": "Хайбол",
                "cocktailCount": 178
            },
            {
                "id": 323,
                "name": "Коктейльний келих",
                "cocktailCount": 154
            },
            {
                "id": 379,
                "name": "Чарка",
                "cocktailCount": 132
            },
            {
                "id": 274,
                "name": "Шампанське блюдце",
                "cocktailCount": 75
            },
            {
                "id": 1052,
                "name": "Келих для ірландської кави",
                "cocktailCount": 51
            },
            {
                "id": 1008,
                "name": "Слінг",
                "cocktailCount": 41
            },
            {
                "id": 1132,
                "name": "Колінз",
                "cocktailCount": 27
            },
            {
                "id": 1034,
                "name": "Флюте",
                "cocktailCount": 26
            },
            {
                "id": 1031,
                "name": "Келих для вина",
                "cocktailCount": 25
            },
            {
                "id": 1019,
                "name": "Кубок",
                "cocktailCount": 19
            },
            {
                "id": 26,
                "name": "Харрікейн",
                "cocktailCount": 19
            },
            {
                "id": 1079,
                "name": "Чашка",
                "cocktailCount": 15
            },
            {
                "id": 321,
                "name": "Келих сауер",
                "cocktailCount": 15
            },
            {
                "id": 547,
                "name": "Коктейльна креманка",
                "cocktailCount": 9
            },
            {
                "id": 566,
                "name": "Мідний кухоль",
                "cocktailCount": 8
            },
            {
                "id": 1119,
                "name": "Заварний чайник",
                "cocktailCount": 7
            },
            {
                "id": 1091,
                "name": "Тікі-келих",
                "cocktailCount": 7
            },
            {
                "id": 1101,
                "name": "Коньячний келих",
                "cocktailCount": 6
            },
            {
                "id": 548,
                "name": "Келих Маргарита",
                "cocktailCount": 6
            },
            {
                "id": 355,
                "name": "Саке сет",
                "cocktailCount": 3
            },
            {
                "id": 47,
                "name": "Банка з кришкою",
                "cocktailCount": 2
            },
            {
                "id": 1063,
                "name": "Скляночка для чаю",
                "cocktailCount": 1
            }
        ],
        "selectionType": "SINGLE"
    },
    {
        "id": 1,
        "queryName": "goods",
        "name": "Інгрідієнти",
        "items": [
            {
                "id": 431,
                "name": "Лід в кубиках",
                "cocktailCount": 718
            },
            {
                "id": 131,
                "name": "Лимонний сік",
                "cocktailCount": 289
            },
            {
                "id": 588,
                "name": "Цукровий сироп",
                "cocktailCount": 248
            },
            {
                "id": 130,
                "name": "Лаймовий сік",
                "cocktailCount": 226
            },
            {
                "id": 416,
                "name": "Лід подрібнений",
                "cocktailCount": 176
            },
            {
                "id": 94,
                "name": "Горілка",
                "cocktailCount": 154
            },
            {
                "id": 24,
                "name": "Лондонський сухий джин",
                "cocktailCount": 128
            },
            {
                "id": 539,
                "name": "Лайм",
                "cocktailCount": 124
            },
            {
                "id": 366,
                "name": "М'ята",
                "cocktailCount": 124
            },
            {
                "id": 262,
                "name": "Білий ром",
                "cocktailCount": 103
            },
            {
                "id": 149,
                "name": "Апельсин",
                "cocktailCount": 90
            },
            {
                "id": 53,
                "name": "Апельсинова цедра",
                "cocktailCount": 82
            },
            {
                "id": 598,
                "name": "Білок перепелиного яйця",
                "cocktailCount": 77
            },
            {
                "id": 404,
                "name": "Червона коктейльна вишня",
                "cocktailCount": 73
            },
            {
                "id": 82,
                "name": "Содова",
                "cocktailCount": 73
            },
            {
                "id": 432,
                "name": "Апельсиновий сік",
                "cocktailCount": 68
            },
            {
                "id": 56,
                "name": "Лимонна цедра",
                "cocktailCount": 68
            },
            {
                "id": 52,
                "name": "Ангостура бітер",
                "cocktailCount": 68
            },
            {
                "id": 380,
                "name": "Малина",
                "cocktailCount": 64
            },
            {
                "id": 538,
                "name": "Лимон",
                "cocktailCount": 61
            },
            {
                "id": 512,
                "name": "Медовий сироп",
                "cocktailCount": 60
            },
            {
                "id": 582,
                "name": "Кориця в паличках",
                "cocktailCount": 59
            },
            {
                "id": 48,
                "name": "Полуниця",
                "cocktailCount": 57
            },
            {
                "id": 426,
                "name": "Яблуко",
                "cocktailCount": 56
            },
            {
                "id": 596,
                "name": "Шотландське віскі",
                "cocktailCount": 55
            },
            {
                "id": 271,
                "name": "Мед",
                "cocktailCount": 52
            },
            {
                "id": 221,
                "name": "Просекко",
                "cocktailCount": 49
            },
            {
                "id": 445,
                "name": "Яблучний сік",
                "cocktailCount": 48
            },
            {
                "id": 5,
                "name": "Корінь імбиру",
                "cocktailCount": 48
            },
            {
                "id": 425,
                "name": "Гренадін",
                "cocktailCount": 46
            },
            {
                "id": 134,
                "name": "Сік журавлини",
                "cocktailCount": 44
            },
            {
                "id": 76,
                "name": "Гвоздика",
                "cocktailCount": 42
            },
            {
                "id": 437,
                "name": "Ананасовий сік",
                "cocktailCount": 39
            },
            {
                "id": 433,
                "name": "Грейпфрутовий сік",
                "cocktailCount": 38
            },
            {
                "id": 427,
                "name": "Грейпфрут",
                "cocktailCount": 38
            },
            {
                "id": 286,
                "name": "Крижаний куб",
                "cocktailCount": 38
            },
            {
                "id": 579,
                "name": "Мелена кориця",
                "cocktailCount": 36
            },
            {
                "id": 541,
                "name": "Імбирне пиво",
                "cocktailCount": 36
            },
            {
                "id": 471,
                "name": "Червоний вермут",
                "cocktailCount": 36
            },
            {
                "id": 295,
                "name": "Сіль",
                "cocktailCount": 36
            },
            {
                "id": 245,
                "name": "Мартіні біттер Martini",
                "cocktailCount": 34
            },
            {
                "id": 18,
                "name": "Бурбон Woodford Reserve",
                "cocktailCount": 33
            },
            {
                "id": 487,
                "name": "Спрайт",
                "cocktailCount": 33
            },
            {
                "id": 313,
                "name": "Ванільний сироп",
                "cocktailCount": 33
            },
            {
                "id": 260,
                "name": "Темний ром",
                "cocktailCount": 32
            },
            {
                "id": 142,
                "name": "Цукровий пісок",
                "cocktailCount": 32
            },
            {
                "id": 51,
                "name": "Ананас",
                "cocktailCount": 32
            },
            {
                "id": 331,
                "name": "Золота текіла Sierra",
                "cocktailCount": 31
            },
            {
                "id": 533,
                "name": "Сироп маракуйї",
                "cocktailCount": 31
            },
            {
                "id": 508,
                "name": "Ожина",
                "cocktailCount": 31
            },
            {
                "id": 328,
                "name": "Срібна текіла Sierra",
                "cocktailCount": 30
            },
            {
                "id": 476,
                "name": "Огірок",
                "cocktailCount": 28
            },
            {
                "id": 1021,
                "name": "Коньяк",
                "cocktailCount": 27
            },
            {
                "id": 358,
                "name": "Вода без газу",
                "cocktailCount": 27
            },
            {
                "id": 71,
                "name": "Жирні вершки",
                "cocktailCount": 27
            },
            {
                "id": 238,
                "name": "Мелений мускатний горіх",
                "cocktailCount": 26
            },
            {
                "id": 1,
                "name": "Сироп макадамія",
                "cocktailCount": 26
            },
            {
                "id": 478,
                "name": "Розмарин",
                "cocktailCount": 25
            },
            {
                "id": 302,
                "name": "Сухий вермут",
                "cocktailCount": 25
            },
            {
                "id": 1024,
                "name": "Трипл сек De Kuyper",
                "cocktailCount": 24
            },
            {
                "id": 369,
                "name": "Апельсиновий бітер",
                "cocktailCount": 24
            },
            {
                "id": 591,
                "name": "Червоний соус табаско",
                "cocktailCount": 23
            },
            {
                "id": 68,
                "name": "Молоко",
                "cocktailCount": 23
            },
            {
                "id": 73,
                "name": "Кальвадос",
                "cocktailCount": 22
            },
            {
                "id": 488,
                "name": "Цукрова пудра",
                "cocktailCount": 21
            },
            {
                "id": 263,
                "name": "Золотий ром",
                "cocktailCount": 21
            },
            {
                "id": 196,
                "name": "Домашня ванільна горілка",
                "cocktailCount": 21
            },
            {
                "id": 452,
                "name": "Жовток перепелиного яйця",
                "cocktailCount": 20
            },
            {
                "id": 334,
                "name": "Мигдальний сироп",
                "cocktailCount": 20
            },
            {
                "id": 239,
                "name": "Айріш крім",
                "cocktailCount": 20
            },
            {
                "id": 236,
                "name": "Мелений чорний перець",
                "cocktailCount": 20
            },
            {
                "id": 501,
                "name": "Маракуя",
                "cocktailCount": 19
            },
            {
                "id": 332,
                "name": "Сироп агави",
                "cocktailCount": 18
            },
            {
                "id": 309,
                "name": "Ананасове листя",
                "cocktailCount": 18
            },
            {
                "id": 303,
                "name": "Білий вермут",
                "cocktailCount": 18
            },
            {
                "id": 483,
                "name": "Кленовий сироп",
                "cocktailCount": 17
            },
            {
                "id": 392,
                "name": "Пишо бітер",
                "cocktailCount": 17
            },
            {
                "id": 261,
                "name": "Витриманий ром",
                "cocktailCount": 17
            },
            {
                "id": 228,
                "name": "Сироп кориці",
                "cocktailCount": 17
            },
            {
                "id": 315,
                "name": "Чорниця",
                "cocktailCount": 16
            },
            {
                "id": 250,
                "name": "Амаро",
                "cocktailCount": 16
            },
            {
                "id": 32,
                "name": "Лікер драй оранж De Kuyper",
                "cocktailCount": 16
            },
            {
                "id": 1030,
                "name": "Лікер мараскино De Kuyper",
                "cocktailCount": 15
            },
            {
                "id": 1011,
                "name": "Кавовий лікер De Kuyper",
                "cocktailCount": 15
            },
            {
                "id": 459,
                "name": "Зелений базилік",
                "cocktailCount": 15
            },
            {
                "id": 444,
                "name": "Томатний сік",
                "cocktailCount": 15
            },
            {
                "id": 428,
                "name": "Малиновий сироп",
                "cocktailCount": 15
            },
            {
                "id": 367,
                "name": "Херес Педро Хіменес",
                "cocktailCount": 15
            },
            {
                "id": 364,
                "name": "Сухе червоне вино",
                "cocktailCount": 15
            },
            {
                "id": 327,
                "name": "Мескаль",
                "cocktailCount": 15
            },
            {
                "id": 253,
                "name": "Самбука",
                "cocktailCount": 15
            },
            {
                "id": 524,
                "name": "Тростинний цукровий пісок",
                "cocktailCount": 14
            },
            {
                "id": 356,
                "name": "Пелюстки троянд",
                "cocktailCount": 14
            },
            {
                "id": 318,
                "name": "Журавлина",
                "cocktailCount": 14
            },
            {
                "id": 9,
                "name": "Динний лікер De Kuyper",
                "cocktailCount": 14
            },
            {
                "id": 1057,
                "name": "Абсент",
                "cocktailCount": 13
            },
            {
                "id": 490,
                "name": "Курага",
                "cocktailCount": 13
            },
            {
                "id": 457,
                "name": "Імбирний сироп",
                "cocktailCount": 13
            },
            {
                "id": 98,
                "name": "Перець чилі",
                "cocktailCount": 13
            },
            {
                "id": 281,
                "name": "Лікер амарето De Kuyper",
                "cocktailCount": 12
            },
            {
                "id": 514,
                "name": "Лимонна трава",
                "cocktailCount": 12
            },
            {
                "id": 446,
                "name": "Вишневий сік",
                "cocktailCount": 12
            },
            {
                "id": 372,
                "name": "Портвейн Тоні",
                "cocktailCount": 12
            },
            {
                "id": 345,
                "name": "Кава еспресо",
                "cocktailCount": 12
            },
            {
                "id": 240,
                "name": "Ірландський віскі",
                "cocktailCount": 12
            },
            {
                "id": 144,
                "name": "Чорнослив",
                "cocktailCount": 12
            },
            {
                "id": 93,
                "name": "Крижана сфера",
                "cocktailCount": 12
            },
            {
                "id": 17,
                "name": "Американський віскі Jack Daniel’s",
                "cocktailCount": 12
            },
            {
                "id": 605,
                "name": "Полуничний сироп",
                "cocktailCount": 11
            },
            {
                "id": 537,
                "name": "Мандарин",
                "cocktailCount": 11
            },
            {
                "id": 525,
                "name": "Тростинний цукор в кубиках",
                "cocktailCount": 11
            },
            {
                "id": 362,
                "name": "Кола",
                "cocktailCount": 11
            },
            {
                "id": 359,
                "name": "Вода з квіток апельсина",
                "cocktailCount": 11
            },
            {
                "id": 348,
                "name": "Зелений шартрез",
                "cocktailCount": 11
            },
            {
                "id": 341,
                "name": "Апельсинова горілка",
                "cocktailCount": 11
            },
            {
                "id": 339,
                "name": "Цитрусова горілка",
                "cocktailCount": 11
            },
            {
                "id": 317,
                "name": "Червона смородина",
                "cocktailCount": 11
            },
            {
                "id": 288,
                "name": "Чорний шоколад",
                "cocktailCount": 11
            },
            {
                "id": 254,
                "name": "Лімончело",
                "cocktailCount": 11
            },
            {
                "id": 232,
                "name": "Вишневий лікер De Kuyper",
                "cocktailCount": 11
            },
            {
                "id": 125,
                "name": "Манго",
                "cocktailCount": 11
            },
            {
                "id": 84,
                "name": "Тонік",
                "cocktailCount": 11
            },
            {
                "id": 72,
                "name": "Нежирні вершки",
                "cocktailCount": 11
            },
            {
                "id": 54,
                "name": "Грейпфрутова цедра",
                "cocktailCount": 11
            },
            {
                "id": 105,
                "name": "Ревеневий лікер De Kuyper",
                "cocktailCount": 10
            },
            {
                "id": 540,
                "name": "Бодян",
                "cocktailCount": 10
            },
            {
                "id": 481,
                "name": "Гранат",
                "cocktailCount": 10
            },
            {
                "id": 456,
                "name": "Червоний базилік",
                "cocktailCount": 10
            },
            {
                "id": 304,
                "name": "Пиво світле",
                "cocktailCount": 10
            },
            {
                "id": 277,
                "name": "Ківі",
                "cocktailCount": 10
            },
            {
                "id": 264,
                "name": "Надміцний ром",
                "cocktailCount": 10
            },
            {
                "id": 258,
                "name": "Бехерівка",
                "cocktailCount": 10
            },
            {
                "id": 90,
                "name": "Дженевер",
                "cocktailCount": 10
            },
            {
                "id": 79,
                "name": "Бенедиктин",
                "cocktailCount": 10
            },
            {
                "id": 611,
                "name": "Саке",
                "cocktailCount": 9
            },
            {
                "id": 595,
                "name": "Драмбуї",
                "cocktailCount": 9
            },
            {
                "id": 558,
                "name": "Лікер з квіток бузини De Kuyper",
                "cocktailCount": 9
            },
            {
                "id": 482,
                "name": "Квіти фіалки",
                "cocktailCount": 9
            },
            {
                "id": 472,
                "name": "Грейпфрутовий бітер",
                "cocktailCount": 9
            },
            {
                "id": 403,
                "name": "Кавун",
                "cocktailCount": 9
            },
            {
                "id": 265,
                "name": "Пряний ром",
                "cocktailCount": 9
            },
            {
                "id": 244,
                "name": "Херес Фіно",
                "cocktailCount": 9
            },
            {
                "id": 226,
                "name": "Соус Ворчестер",
                "cocktailCount": 9
            },
            {
                "id": 146,
                "name": "Вишня",
                "cocktailCount": 9
            },
            {
                "id": 29,
                "name": "Чебрець",
                "cocktailCount": 9
            },
            {
                "id": 606,
                "name": "Чорносмородиновий сироп",
                "cocktailCount": 8
            },
            {
                "id": 544,
                "name": "Піско",
                "cocktailCount": 8
            },
            {
                "id": 498,
                "name": "Банан",
                "cocktailCount": 8
            },
            {
                "id": 484,
                "name": "Кава в зернах",
                "cocktailCount": 8
            },
            {
                "id": 434,
                "name": "Гранатовий сік",
                "cocktailCount": 8
            },
            {
                "id": 414,
                "name": "Персикове пюре",
                "cocktailCount": 8
            },
            {
                "id": 391,
                "name": "Лікер кориці",
                "cocktailCount": 8
            },
            {
                "id": 390,
                "name": "Сироп троянди",
                "cocktailCount": 8
            },
            {
                "id": 382,
                "name": "Печиво",
                "cocktailCount": 8
            },
            {
                "id": 360,
                "name": "Рожевий вермут",
                "cocktailCount": 8
            },
            {
                "id": 340,
                "name": "Чорносмородинова горілка",
                "cocktailCount": 8
            },
            {
                "id": 311,
                "name": "Біле вино сухе",
                "cocktailCount": 8
            },
            {
                "id": 310,
                "name": "Лаймове листя",
                "cocktailCount": 8
            },
            {
                "id": 294,
                "name": "Орхідея",
                "cocktailCount": 8
            },
            {
                "id": 229,
                "name": "Карамельний сироп",
                "cocktailCount": 8
            },
            {
                "id": 222,
                "name": "Зелений виноград",
                "cocktailCount": 8
            },
            {
                "id": 148,
                "name": "Яблучний сироп жовтий",
                "cocktailCount": 8
            },
            {
                "id": 66,
                "name": "Лікер лічі De Kuyper",
                "cocktailCount": 8
            },
            {
                "id": 580,
                "name": "Кардамон",
                "cocktailCount": 7
            },
            {
                "id": 517,
                "name": "Чинар",
                "cocktailCount": 7
            },
            {
                "id": 458,
                "name": "Пряний сироп",
                "cocktailCount": 7
            },
            {
                "id": 415,
                "name": "Домашня перцева горілка",
                "cocktailCount": 7
            },
            {
                "id": 397,
                "name": "Ваніль в стручках",
                "cocktailCount": 7
            },
            {
                "id": 383,
                "name": "Кумкват",
                "cocktailCount": 7
            },
            {
                "id": 370,
                "name": "Херес Олоросо",
                "cocktailCount": 7
            },
            {
                "id": 322,
                "name": "Малинове пюре",
                "cocktailCount": 7
            },
            {
                "id": 319,
                "name": "Чорна смородина",
                "cocktailCount": 7
            },
            {
                "id": 283,
                "name": "Ванільний цукровий пісок",
                "cocktailCount": 7
            },
            {
                "id": 259,
                "name": "Лікер фалернум",
                "cocktailCount": 7
            },
            {
                "id": 234,
                "name": "Селера",
                "cocktailCount": 7
            },
            {
                "id": 55,
                "name": "Лаймова цедра",
                "cocktailCount": 7
            },
            {
                "id": 10,
                "name": "Лікер манго De Kuyper",
                "cocktailCount": 7
            },
            {
                "id": 1012,
                "name": "Коричневий какао лікер De Kuyper",
                "cocktailCount": 6
            },
            {
                "id": 1009,
                "name": "Односолодове віскі з острова Айла",
                "cocktailCount": 6
            },
            {
                "id": 597,
                "name": "Односолодовий віскі хайленд The Macallan",
                "cocktailCount": 6
            },
            {
                "id": 572,
                "name": "Ванільне морозиво",
                "cocktailCount": 6
            },
            {
                "id": 567,
                "name": "Персиковий бітер",
                "cocktailCount": 6
            },
            {
                "id": 552,
                "name": "Морин кіна",
                "cocktailCount": 6
            },
            {
                "id": 509,
                "name": "Фізаліс",
                "cocktailCount": 6
            },
            {
                "id": 486,
                "name": "Шоколадний бітер",
                "cocktailCount": 6
            },
            {
                "id": 453,
                "name": "Коріандр",
                "cocktailCount": 6
            },
            {
                "id": 420,
                "name": "Полуничне пюре",
                "cocktailCount": 6
            },
            {
                "id": 363,
                "name": "Кокосовий сироп",
                "cocktailCount": 6
            },
            {
                "id": 335,
                "name": "Тарталетка",
                "cocktailCount": 6
            },
            {
                "id": 305,
                "name": "Сироп лимоннику",
                "cocktailCount": 6
            },
            {
                "id": 266,
                "name": "Лікер піменто драм",
                "cocktailCount": 6
            },
            {
                "id": 251,
                "name": "Гальяно Л'Аутентіко",
                "cocktailCount": 6
            },
            {
                "id": 249,
                "name": "Італікус",
                "cocktailCount": 6
            },
            {
                "id": 190,
                "name": "Домашній кардамоновий бітер",
                "cocktailCount": 6
            },
            {
                "id": 141,
                "name": "Енергетик",
                "cocktailCount": 6
            },
            {
                "id": 116,
                "name": "Апельсиновий джем",
                "cocktailCount": 6
            },
            {
                "id": 91,
                "name": "Яєчний лікер",
                "cocktailCount": 6
            },
            {
                "id": 61,
                "name": "Чорний чай",
                "cocktailCount": 6
            },
            {
                "id": 42,
                "name": "Кашаса",
                "cocktailCount": 6
            },
            {
                "id": 27,
                "name": "Рожева вода",
                "cocktailCount": 6
            },
            {
                "id": 67,
                "name": "Лікер маракуйї De Kuyper",
                "cocktailCount": 5
            },
            {
                "id": 1087,
                "name": "Кокосовий лікер De Kuyper",
                "cocktailCount": 5
            },
            {
                "id": 1103,
                "name": "Жовтий банановий лікер De Kuyper",
                "cocktailCount": 5
            },
            {
                "id": 1140,
                "name": "Абрикосовий лікер De Kuyper",
                "cocktailCount": 5
            },
            {
                "id": 19,
                "name": "Житнє віскі Woodford Reserve",
                "cocktailCount": 5
            },
            {
                "id": 616,
                "name": "Сушений ананас",
                "cocktailCount": 5
            },
            {
                "id": 555,
                "name": "Лілле Блан",
                "cocktailCount": 5
            },
            {
                "id": 553,
                "name": "Гентіана",
                "cocktailCount": 5
            },
            {
                "id": 530,
                "name": "Банановий сироп жовтий",
                "cocktailCount": 5
            },
            {
                "id": 526,
                "name": "Кокосовий крем",
                "cocktailCount": 5
            },
            {
                "id": 279,
                "name": "Оливки",
                "cocktailCount": 5
            },
            {
                "id": 248,
                "name": "Фернет бранка",
                "cocktailCount": 5
            },
            {
                "id": 227,
                "name": "Апероль",
                "cocktailCount": 5
            },
            {
                "id": 143,
                "name": "Цукор в кубиках",
                "cocktailCount": 5
            },
            {
                "id": 112,
                "name": "Вишневий джем",
                "cocktailCount": 5
            },
            {
                "id": 97,
                "name": "Мелений червоний перець",
                "cocktailCount": 5
            },
            {
                "id": 77,
                "name": "Витриманий бурбон Woodford Reserve",
                "cocktailCount": 5
            },
            {
                "id": 12,
                "name": "Сироп манго",
                "cocktailCount": 5
            },
            {
                "id": 1100,
                "name": "Мандариновий сироп",
                "cocktailCount": 4
            },
            {
                "id": 1051,
                "name": "Грейпфрутовий лікер De Kuyper",
                "cocktailCount": 4
            },
            {
                "id": 1014,
                "name": "Ожиновий лікер De Kuyper",
                "cocktailCount": 4
            },
            {
                "id": 1028,
                "name": "Лікер блю курасао De Kuyper",
                "cocktailCount": 4
            },
            {
                "id": 1023,
                "name": "Персиковий лікер De Kuyper",
                "cocktailCount": 4
            },
            {
                "id": 546,
                "name": "Чай ерл грей",
                "cocktailCount": 4
            },
            {
                "id": 534,
                "name": "Карамбола",
                "cocktailCount": 4
            },
            {
                "id": 502,
                "name": "Лічі",
                "cocktailCount": 4
            },
            {
                "id": 500,
                "name": "Стручковий перець солодкий",
                "cocktailCount": 4
            },
            {
                "id": 497,
                "name": "Лаймовий сироп",
                "cocktailCount": 4
            },
            {
                "id": 492,
                "name": "Персик",
                "cocktailCount": 4
            },
            {
                "id": 477,
                "name": "Солоний огірок",
                "cocktailCount": 4
            },
            {
                "id": 475,
                "name": "Шафран",
                "cocktailCount": 4
            },
            {
                "id": 460,
                "name": "Пюре з лічі",
                "cocktailCount": 4
            },
            {
                "id": 440,
                "name": "Персиковий сік",
                "cocktailCount": 4
            },
            {
                "id": 421,
                "name": "Холодний зелений чай",
                "cocktailCount": 4
            },
            {
                "id": 406,
                "name": "Мелена кава",
                "cocktailCount": 4
            },
            {
                "id": 393,
                "name": "Південний комфорт",
                "cocktailCount": 4
            },
            {
                "id": 365,
                "name": "Кава американо",
                "cocktailCount": 4
            },
            {
                "id": 243,
                "name": "Херес Амонтіл’ядо",
                "cocktailCount": 4
            },
            {
                "id": 124,
                "name": "Шавлія",
                "cocktailCount": 4
            },
            {
                "id": 117,
                "name": "Малиновий джем",
                "cocktailCount": 4
            },
            {
                "id": 113,
                "name": "Обліпиховий джем",
                "cocktailCount": 4
            },
            {
                "id": 111,
                "name": "Збиті вершки",
                "cocktailCount": 4
            },
            {
                "id": 107,
                "name": "Шоколадний сироп",
                "cocktailCount": 4
            },
            {
                "id": 100,
                "name": "Мастиха",
                "cocktailCount": 4
            },
            {
                "id": 83,
                "name": "Бітер лемон",
                "cocktailCount": 4
            },
            {
                "id": 75,
                "name": "Кокосова стружка",
                "cocktailCount": 4
            },
            {
                "id": 57,
                "name": "Солодкий херес блендовий",
                "cocktailCount": 4
            },
            {
                "id": 34,
                "name": "Кунжут",
                "cocktailCount": 4
            },
            {
                "id": 11,
                "name": "Сироп лічі",
                "cocktailCount": 4
            },
            {
                "id": 3,
                "name": "Ревеневий бітер",
                "cocktailCount": 4
            },
            {
                "id": 1070,
                "name": "Чорносмородиновий лікер De Kuyper",
                "cocktailCount": 3
            },
            {
                "id": 1118,
                "name": "Чай асам",
                "cocktailCount": 3
            },
            {
                "id": 612,
                "name": "Японське віскі",
                "cocktailCount": 3
            },
            {
                "id": 608,
                "name": "Сливове вино",
                "cocktailCount": 3
            },
            {
                "id": 607,
                "name": "Вишневий сироп",
                "cocktailCount": 3
            },
            {
                "id": 602,
                "name": "Білий винний оцет",
                "cocktailCount": 3
            },
            {
                "id": 590,
                "name": "Червоний виноград",
                "cocktailCount": 3
            },
            {
                "id": 586,
                "name": "Лікер юдзу",
                "cocktailCount": 3
            },
            {
                "id": 571,
                "name": "Cтрега",
                "cocktailCount": 3
            },
            {
                "id": 569,
                "name": "Груша",
                "cocktailCount": 3
            },
            {
                "id": 565,
                "name": "Мармелад",
                "cocktailCount": 3
            },
            {
                "id": 564,
                "name": "Яблучний сидр",
                "cocktailCount": 3
            },
            {
                "id": 532,
                "name": "Ананасовий сироп",
                "cocktailCount": 3
            },
            {
                "id": 523,
                "name": "Кокосова вода",
                "cocktailCount": 3
            },
            {
                "id": 513,
                "name": "Рукола",
                "cocktailCount": 3
            },
            {
                "id": 499,
                "name": "Фісташковий сироп",
                "cocktailCount": 3
            },
            {
                "id": 474,
                "name": "Хрін",
                "cocktailCount": 3
            },
            {
                "id": 466,
                "name": "Жовтий яблучний лікер",
                "cocktailCount": 3
            },
            {
                "id": 442,
                "name": "Сік маракуйї",
                "cocktailCount": 3
            },
            {
                "id": 441,
                "name": "Манговий сік",
                "cocktailCount": 3
            },
            {
                "id": 435,
                "name": "Мандариновий сік",
                "cocktailCount": 3
            },
            {
                "id": 417,
                "name": "Трюфельна олія",
                "cocktailCount": 3
            },
            {
                "id": 409,
                "name": "Паростки гороху з приправами",
                "cocktailCount": 3
            },
            {
                "id": 405,
                "name": "Пиво темне",
                "cocktailCount": 3
            },
            {
                "id": 374,
                "name": "Ромашковий чай",
                "cocktailCount": 3
            },
            {
                "id": 337,
                "name": "Кокосовий ром",
                "cocktailCount": 3
            },
            {
                "id": 326,
                "name": "Лікер перцю анчо",
                "cocktailCount": 3
            },
            {
                "id": 320,
                "name": "Брусниця",
                "cocktailCount": 3
            },
            {
                "id": 298,
                "name": "Селерова сіль",
                "cocktailCount": 3
            },
            {
                "id": 297,
                "name": "Рожева сіль",
                "cocktailCount": 3
            },
            {
                "id": 252,
                "name": "Граппа",
                "cocktailCount": 3
            },
            {
                "id": 247,
                "name": "Сир маскарпоне",
                "cocktailCount": 3
            },
            {
                "id": 242,
                "name": "Херес Манзанілья",
                "cocktailCount": 3
            },
            {
                "id": 224,
                "name": "Яблучний сироп зелений",
                "cocktailCount": 3
            },
            {
                "id": 216,
                "name": "Домашній медово-імбирний сироп",
                "cocktailCount": 3
            },
            {
                "id": 205,
                "name": "Домашня цитрусова олія",
                "cocktailCount": 3
            },
            {
                "id": 203,
                "name": "Домашній джин на гібіскусі та прянощах",
                "cocktailCount": 3
            },
            {
                "id": 176,
                "name": "Домашній цитрусовий бітер",
                "cocktailCount": 3
            },
            {
                "id": 160,
                "name": "Домашня томатна вода",
                "cocktailCount": 3
            },
            {
                "id": 151,
                "name": "Домашній мускатний бітер",
                "cocktailCount": 3
            },
            {
                "id": 147,
                "name": "Свіжоморожена вишня",
                "cocktailCount": 3
            },
            {
                "id": 126,
                "name": "Копчений чай",
                "cocktailCount": 3
            },
            {
                "id": 121,
                "name": "Абрикосовий джем",
                "cocktailCount": 3
            },
            {
                "id": 101,
                "name": "Ревінь",
                "cocktailCount": 3
            },
            {
                "id": 92,
                "name": "Терновий джин",
                "cocktailCount": 3
            },
            {
                "id": 39,
                "name": "Селеровий бітер",
                "cocktailCount": 3
            },
            {
                "id": 37,
                "name": "Бананове пюре",
                "cocktailCount": 3
            },
            {
                "id": 36,
                "name": "Щавель",
                "cocktailCount": 3
            },
            {
                "id": 7,
                "name": "Інжир",
                "cocktailCount": 3
            },
            {
                "id": 2,
                "name": "Лавандовий бітер",
                "cocktailCount": 3
            },
            {
                "id": 215,
                "name": "Домашній лікер на ромі з ізюмом",
                "cocktailCount": 2
            },
            {
                "id": 1122,
                "name": "Світлий какао-лікер De Kuyper",
                "cocktailCount": 2
            },
            {
                "id": 1144,
                "name": "Диня",
                "cocktailCount": 2
            },
            {
                "id": 1110,
                "name": "Медовий лікер",
                "cocktailCount": 2
            },
            {
                "id": 1098,
                "name": "Домашня нутовая вода",
                "cocktailCount": 2
            },
            {
                "id": 1085,
                "name": "Жасминовий чай",
                "cocktailCount": 2
            },
            {
                "id": 1054,
                "name": "Рожевий перець",
                "cocktailCount": 2
            },
            {
                "id": 1042,
                "name": "Мигдальне молоко",
                "cocktailCount": 2
            },
            {
                "id": 617,
                "name": "Кавуновий сироп",
                "cocktailCount": 2
            },
            {
                "id": 614,
                "name": "Китайський перець в гранулах",
                "cocktailCount": 2
            },
            {
                "id": 604,
                "name": "Ожиновий сироп",
                "cocktailCount": 2
            },
            {
                "id": 603,
                "name": "Винний оцет",
                "cocktailCount": 2
            },
            {
                "id": 589,
                "name": "Чайний бітер",
                "cocktailCount": 2
            },
            {
                "id": 578,
                "name": "Холодний персиковий чай",
                "cocktailCount": 2
            },
            {
                "id": 577,
                "name": "Апельсиновий сорбет",
                "cocktailCount": 2
            },
            {
                "id": 576,
                "name": "Лаймовий сорбет",
                "cocktailCount": 2
            },
            {
                "id": 556,
                "name": "Лілле Руж",
                "cocktailCount": 2
            },
            {
                "id": 554,
                "name": "Дюбонне",
                "cocktailCount": 2
            },
            {
                "id": 551,
                "name": "Пастіс",
                "cocktailCount": 2
            },
            {
                "id": 531,
                "name": "Персиковий сироп",
                "cocktailCount": 2
            },
            {
                "id": 506,
                "name": "Льодяники",
                "cocktailCount": 2
            },
            {
                "id": 504,
                "name": "Зацукрований імбир",
                "cocktailCount": 2
            },
            {
                "id": 489,
                "name": "Соєвий соус",
                "cocktailCount": 2
            },
            {
                "id": 480,
                "name": "Авокадо",
                "cocktailCount": 2
            },
            {
                "id": 473,
                "name": "Лимонний бітер",
                "cocktailCount": 2
            },
            {
                "id": 465,
                "name": "Кунжутна олія",
                "cocktailCount": 2
            },
            {
                "id": 464,
                "name": "Згущене молоко",
                "cocktailCount": 2
            },
            {
                "id": 461,
                "name": "Пюре з лохини",
                "cocktailCount": 2
            },
            {
                "id": 454,
                "name": "Кроп",
                "cocktailCount": 2
            },
            {
                "id": 449,
                "name": "Медові соти",
                "cocktailCount": 2
            },
            {
                "id": 438,
                "name": "Кавуновий сік",
                "cocktailCount": 2
            },
            {
                "id": 436,
                "name": "Морквяний сік",
                "cocktailCount": 2
            },
            {
                "id": 429,
                "name": "Домашній збагачений маслом бурбон",
                "cocktailCount": 2
            },
            {
                "id": 419,
                "name": "Домашній пшеничний кордіал",
                "cocktailCount": 2
            },
            {
                "id": 410,
                "name": "Сироп лаванди",
                "cocktailCount": 2
            },
            {
                "id": 388,
                "name": "Лавандовий мед",
                "cocktailCount": 2
            },
            {
                "id": 361,
                "name": "Смажений арахіс",
                "cocktailCount": 2
            },
            {
                "id": 353,
                "name": "Пюре маракуї",
                "cocktailCount": 2
            },
            {
                "id": 351,
                "name": "Мандаринове пюре",
                "cocktailCount": 2
            },
            {
                "id": 342,
                "name": "Малинова горілка",
                "cocktailCount": 2
            },
            {
                "id": 336,
                "name": "Ананасовий ром",
                "cocktailCount": 2
            },
            {
                "id": 314,
                "name": "Обліпиха",
                "cocktailCount": 2
            },
            {
                "id": 307,
                "name": "Базилікова тинктура",
                "cocktailCount": 2
            },
            {
                "id": 292,
                "name": "Соджу",
                "cocktailCount": 2
            },
            {
                "id": 284,
                "name": "Кокосове пюре",
                "cocktailCount": 2
            },
            {
                "id": 273,
                "name": "Сироп гібіскуса",
                "cocktailCount": 2
            },
            {
                "id": 257,
                "name": "Пармезан",
                "cocktailCount": 2
            },
            {
                "id": 255,
                "name": "Мірто",
                "cocktailCount": 2
            },
            {
                "id": 225,
                "name": "Зелений чай листовий",
                "cocktailCount": 2
            },
            {
                "id": 223,
                "name": "Зелений соус табаско",
                "cocktailCount": 2
            },
            {
                "id": 198,
                "name": "Домашня лавандова горілка",
                "cocktailCount": 2
            },
            {
                "id": 194,
                "name": "Домашній винний сироп",
                "cocktailCount": 2
            },
            {
                "id": 178,
                "name": "Домашня горілка з чилі",
                "cocktailCount": 2
            },
            {
                "id": 164,
                "name": "Домашній сироп на бобах тонка",
                "cocktailCount": 2
            },
            {
                "id": 136,
                "name": "Лецитин",
                "cocktailCount": 2
            },
            {
                "id": 119,
                "name": "Чорносмородиновий джем",
                "cocktailCount": 2
            },
            {
                "id": 109,
                "name": "Малиновий лікер De Kuyper",
                "cocktailCount": 2
            },
            {
                "id": 110,
                "name": "Полуничний лікер",
                "cocktailCount": 2
            },
            {
                "id": 104,
                "name": "Біле вино десертне",
                "cocktailCount": 2
            },
            {
                "id": 102,
                "name": "Устричний соус",
                "cocktailCount": 2
            },
            {
                "id": 96,
                "name": "Сироп фундука",
                "cocktailCount": 2
            },
            {
                "id": 95,
                "name": "Волоський бітер",
                "cocktailCount": 2
            },
            {
                "id": 49,
                "name": "Волоський горіх",
                "cocktailCount": 2
            },
            {
                "id": 40,
                "name": "Сливовий бітер",
                "cocktailCount": 2
            },
            {
                "id": 35,
                "name": "Редька",
                "cocktailCount": 2
            },
            {
                "id": 28,
                "name": "Лаванда",
                "cocktailCount": 2
            },
            {
                "id": 25,
                "name": "Бальзамічний крем",
                "cocktailCount": 2
            },
            {
                "id": 22,
                "name": "Ананасове пюре",
                "cocktailCount": 2
            },
            {
                "id": 15,
                "name": "Фіалковий лікер De Kuyper",
                "cocktailCount": 2
            },
            {
                "id": 16,
                "name": "Бергамот бітер",
                "cocktailCount": 2
            },
            {
                "id": 1138,
                "name": "Зелений м’ятний лікер De Kuyper",
                "cocktailCount": 1
            },
            {
                "id": 1061,
                "name": "Зелений яблучний лікер De Kuyper",
                "cocktailCount": 1
            },
            {
                "id": 1139,
                "name": "Чай дянь хунь",
                "cocktailCount": 1
            },
            {
                "id": 1134,
                "name": "Сироп пряний гарбуз",
                "cocktailCount": 1
            },
            {
                "id": 1131,
                "name": "Грушевий лікер",
                "cocktailCount": 1
            },
            {
                "id": 1130,
                "name": "Домашній білий вермут на печерицях",
                "cocktailCount": 1
            },
            {
                "id": 1128,
                "name": "Шипшина",
                "cocktailCount": 1
            },
            {
                "id": 1124,
                "name": "Ожинове морозиво",
                "cocktailCount": 1
            },
            {
                "id": 1116,
                "name": "Домашній суничний віскі",
                "cocktailCount": 1
            },
            {
                "id": 1115,
                "name": "Свіжоморожена полуниця",
                "cocktailCount": 1
            },
            {
                "id": 1111,
                "name": "Домашній джин на тахіні",
                "cocktailCount": 1
            },
            {
                "id": 1095,
                "name": "Пітайя",
                "cocktailCount": 1
            },
            {
                "id": 1093,
                "name": "Соляна тинктура",
                "cocktailCount": 1
            },
            {
                "id": 1092,
                "name": "Чай сенча",
                "cocktailCount": 1
            },
            {
                "id": 1090,
                "name": "Тріски з ароматом шоколаду",
                "cocktailCount": 1
            },
            {
                "id": 1088,
                "name": "Естрагон",
                "cocktailCount": 1
            },
            {
                "id": 1084,
                "name": "Хризантема",
                "cocktailCount": 1
            },
            {
                "id": 1080,
                "name": "Домашня горілка з коріандром",
                "cocktailCount": 1
            },
            {
                "id": 1073,
                "name": "Верджус",
                "cocktailCount": 1
            },
            {
                "id": 1072,
                "name": "Ромашковий чай в пакетиках",
                "cocktailCount": 1
            },
            {
                "id": 1071,
                "name": "Вафля",
                "cocktailCount": 1
            },
            {
                "id": 1068,
                "name": "Шартрез бітер",
                "cocktailCount": 1
            },
            {
                "id": 1067,
                "name": "Зацукрований кумкват",
                "cocktailCount": 1
            },
            {
                "id": 1066,
                "name": "Какао-порошок",
                "cocktailCount": 1
            },
            {
                "id": 1065,
                "name": "Насіння фенхелю",
                "cocktailCount": 1
            },
            {
                "id": 1062,
                "name": "Фейхоа",
                "cocktailCount": 1
            },
            {
                "id": 1060,
                "name": "Домашня збагачена маслом какао Зубрівка",
                "cocktailCount": 1
            },
            {
                "id": 1053,
                "name": "Домашнє вино з маракуї",
                "cocktailCount": 1
            },
            {
                "id": 1048,
                "name": "Спіруліна",
                "cocktailCount": 1
            },
            {
                "id": 1047,
                "name": "Мандариновий лікер",
                "cocktailCount": 1
            },
            {
                "id": 1046,
                "name": "Бамбукове вугілля подрібнене",
                "cocktailCount": 1
            },
            {
                "id": 1045,
                "name": "Домашній сосново-медовий сироп",
                "cocktailCount": 1
            },
            {
                "id": 1036,
                "name": "Витриманий коньяк",
                "cocktailCount": 1
            },
            {
                "id": 1033,
                "name": "Локричний бітер",
                "cocktailCount": 1
            },
            {
                "id": 1032,
                "name": "Домашній улуновий кордіал",
                "cocktailCount": 1
            },
            {
                "id": 1020,
                "name": "Домашній лавандовий джин",
                "cocktailCount": 1
            },
            {
                "id": 1018,
                "name": "Яблучний сорбет",
                "cocktailCount": 1
            },
            {
                "id": 1013,
                "name": "Iнжирний сироп",
                "cocktailCount": 1
            },
            {
                "id": 613,
                "name": "Маття",
                "cocktailCount": 1
            },
            {
                "id": 610,
                "name": "Umami bitters",
                "cocktailCount": 1
            },
            {
                "id": 609,
                "name": "Лікер квітучої вишні",
                "cocktailCount": 1
            },
            {
                "id": 599,
                "name": "Вишневий бітер",
                "cocktailCount": 1
            },
            {
                "id": 593,
                "name": "Грушевий бренді",
                "cocktailCount": 1
            },
            {
                "id": 592,
                "name": "Аквавіт",
                "cocktailCount": 1
            },
            {
                "id": 587,
                "name": "Ірисковий сироп",
                "cocktailCount": 1
            },
            {
                "id": 575,
                "name": "Шоколадне морозиво",
                "cocktailCount": 1
            },
            {
                "id": 574,
                "name": "Полуничне морозиво",
                "cocktailCount": 1
            },
            {
                "id": 573,
                "name": "Малинове морозиво",
                "cocktailCount": 1
            },
            {
                "id": 570,
                "name": "Желатин",
                "cocktailCount": 1
            },
            {
                "id": 568,
                "name": "Яблучний оцет",
                "cocktailCount": 1
            },
            {
                "id": 563,
                "name": "Вершковий сир",
                "cocktailCount": 1
            },
            {
                "id": 559,
                "name": "Cироп солона карамель",
                "cocktailCount": 1
            },
            {
                "id": 550,
                "name": "Джем з лохини",
                "cocktailCount": 1
            },
            {
                "id": 549,
                "name": "Квітка-карнівор",
                "cocktailCount": 1
            },
            {
                "id": 545,
                "name": "Цвак Унікум",
                "cocktailCount": 1
            },
            {
                "id": 542,
                "name": "Арак Батавія",
                "cocktailCount": 1
            },
            {
                "id": 535,
                "name": "Гуава",
                "cocktailCount": 1
            },
            {
                "id": 521,
                "name": "Гібіскус в сиропі",
                "cocktailCount": 1
            },
            {
                "id": 516,
                "name": "Фенхелевий бітер",
                "cocktailCount": 1
            },
            {
                "id": 510,
                "name": "Томатний мікс",
                "cocktailCount": 1
            },
            {
                "id": 505,
                "name": "Тамаринд",
                "cocktailCount": 1
            },
            {
                "id": 503,
                "name": "Пшеничний колос",
                "cocktailCount": 1
            },
            {
                "id": 495,
                "name": "Ебботтс бітер",
                "cocktailCount": 1
            },
            {
                "id": 493,
                "name": "Абрикос",
                "cocktailCount": 1
            },
            {
                "id": 463,
                "name": "Халапіньйо",
                "cocktailCount": 1
            },
            {
                "id": 462,
                "name": "Гвоздичний бітер",
                "cocktailCount": 1
            },
            {
                "id": 451,
                "name": "Перепелине яйце",
                "cocktailCount": 1
            },
            {
                "id": 443,
                "name": "Сік папайї",
                "cocktailCount": 1
            },
            {
                "id": 439,
                "name": "Сік з лимонів-гриль",
                "cocktailCount": 1
            },
            {
                "id": 430,
                "name": "Портвейн ЛБВ",
                "cocktailCount": 1
            },
            {
                "id": 424,
                "name": "Лимонад дюшес",
                "cocktailCount": 1
            },
            {
                "id": 423,
                "name": "Грейпфрутова газована вода",
                "cocktailCount": 1
            },
            {
                "id": 422,
                "name": "Фісташки",
                "cocktailCount": 1
            },
            {
                "id": 418,
                "name": "Шишка",
                "cocktailCount": 1
            },
            {
                "id": 413,
                "name": "Маринована цибуля",
                "cocktailCount": 1
            },
            {
                "id": 412,
                "name": "Пекан",
                "cocktailCount": 1
            },
            {
                "id": 408,
                "name": "Соєве борошно",
                "cocktailCount": 1
            },
            {
                "id": 402,
                "name": "Кленовий бітер",
                "cocktailCount": 1
            },
            {
                "id": 401,
                "name": "Орегано",
                "cocktailCount": 1
            },
            {
                "id": 398,
                "name": "Листя кукурудзи",
                "cocktailCount": 1
            },
            {
                "id": 394,
                "name": "Дед реббіт оріноко бітер",
                "cocktailCount": 1
            },
            {
                "id": 381,
                "name": "Свіжоморожена малина",
                "cocktailCount": 1
            },
            {
                "id": 376,
                "name": "Липовий чай",
                "cocktailCount": 1
            },
            {
                "id": 375,
                "name": "Вересовий чай",
                "cocktailCount": 1
            },
            {
                "id": 371,
                "name": "Кава терпентинна",
                "cocktailCount": 1
            },
            {
                "id": 357,
                "name": "Корінь фенхелю",
                "cocktailCount": 1
            },
            {
                "id": 354,
                "name": "Пюре манго",
                "cocktailCount": 1
            },
            {
                "id": 350,
                "name": "Пюре червоної смородини",
                "cocktailCount": 1
            },
            {
                "id": 347,
                "name": "Портвейн Бранко",
                "cocktailCount": 1
            },
            {
                "id": 346,
                "name": "Сухий лід",
                "cocktailCount": 1
            },
            {
                "id": 343,
                "name": "Лікер вербени",
                "cocktailCount": 1
            },
            {
                "id": 338,
                "name": "Кокосова горілка",
                "cocktailCount": 1
            },
            {
                "id": 325,
                "name": "Чипотле",
                "cocktailCount": 1
            },
            {
                "id": 324,
                "name": "Масло какао",
                "cocktailCount": 1
            },
            {
                "id": 316,
                "name": "Калина",
                "cocktailCount": 1
            },
            {
                "id": 306,
                "name": "Евкаліптова тинктура",
                "cocktailCount": 1
            },
            {
                "id": 300,
                "name": "Єгермейстер",
                "cocktailCount": 1
            },
            {
                "id": 296,
                "name": "Копчена сіль",
                "cocktailCount": 1
            },
            {
                "id": 291,
                "name": "Корінь корейського червоного женьшеню",
                "cocktailCount": 1
            },
            {
                "id": 290,
                "name": "Консервований ананас",
                "cocktailCount": 1
            },
            {
                "id": 289,
                "name": "Консервований персик",
                "cocktailCount": 1
            },
            {
                "id": 287,
                "name": "Бісквіт",
                "cocktailCount": 1
            },
            {
                "id": 285,
                "name": "Кавовий сироп",
                "cocktailCount": 1
            },
            {
                "id": 276,
                "name": "Йогурт",
                "cocktailCount": 1
            },
            {
                "id": 275,
                "name": "Кефір",
                "cocktailCount": 1
            },
            {
                "id": 272,
                "name": "Ромашковий лікер",
                "cocktailCount": 1
            },
            {
                "id": 270,
                "name": "Квіти ромашки",
                "cocktailCount": 1
            },
            {
                "id": 269,
                "name": "Лещиця",
                "cocktailCount": 1
            },
            {
                "id": 267,
                "name": "Лікер 43",
                "cocktailCount": 1
            },
            {
                "id": 256,
                "name": "Бітер з лопуха",
                "cocktailCount": 1
            },
            {
                "id": 246,
                "name": "Бальзамічний оцет",
                "cocktailCount": 1
            },
            {
                "id": 241,
                "name": "Витриманий чистий віскі",
                "cocktailCount": 1
            },
            {
                "id": 237,
                "name": "Тамаринд соус",
                "cocktailCount": 1
            },
            {
                "id": 233,
                "name": "Харчове сусальне золото",
                "cocktailCount": 1
            },
            {
                "id": 220,
                "name": "Домашній ягідний чатні",
                "cocktailCount": 1
            },
            {
                "id": 219,
                "name": "Домашній бурбон на масалі",
                "cocktailCount": 1
            },
            {
                "id": 218,
                "name": "Домашній місо сироп",
                "cocktailCount": 1
            },
            {
                "id": 217,
                "name": "Домашній сироп з стручкового горошку",
                "cocktailCount": 1
            },
            {
                "id": 214,
                "name": "Домашній Мартінез",
                "cocktailCount": 1
            },
            {
                "id": 213,
                "name": "Домашня орчата з манго та кеш’ю",
                "cocktailCount": 1
            },
            {
                "id": 212,
                "name": "Домашній кордіал Модена",
                "cocktailCount": 1
            },
            {
                "id": 210,
                "name": "Домашній джин на улуні",
                "cocktailCount": 1
            },
            {
                "id": 209,
                "name": "Домашній сироп маракуї з коріандром",
                "cocktailCount": 1
            },
            {
                "id": 208,
                "name": "Збагачений олією гхі дамсол",
                "cocktailCount": 1
            },
            {
                "id": 207,
                "name": "Домашній оршад на фісташках",
                "cocktailCount": 1
            },
            {
                "id": 206,
                "name": "Домашній какао лікер на кафір-лаймі",
                "cocktailCount": 1
            },
            {
                "id": 204,
                "name": "Домашній бітер Мілано",
                "cocktailCount": 1
            },
            {
                "id": 202,
                "name": "Домашній хініновий лікер із ананасом",
                "cocktailCount": 1
            },
            {
                "id": 201,
                "name": "Домашній джин на мандаринових кірках",
                "cocktailCount": 1
            },
            {
                "id": 200,
                "name": "Домашня макова горілка",
                "cocktailCount": 1
            },
            {
                "id": 199,
                "name": "Домашня бісквітна горілка",
                "cocktailCount": 1
            },
            {
                "id": 197,
                "name": "Домашній ванільний ром",
                "cocktailCount": 1
            },
            {
                "id": 195,
                "name": "Домашня перцева текіла",
                "cocktailCount": 1
            },
            {
                "id": 193,
                "name": "Домашня пряна горілка",
                "cocktailCount": 1
            },
            {
                "id": 192,
                "name": "Домашня полунична текіла",
                "cocktailCount": 1
            },
            {
                "id": 191,
                "name": "Домашній калиновий кордіал",
                "cocktailCount": 1
            },
            {
                "id": 189,
                "name": "Домашній сироп «п'яна вишня»",
                "cocktailCount": 1
            },
            {
                "id": 188,
                "name": "Домашній сироп з фруктозою",
                "cocktailCount": 1
            },
            {
                "id": 187,
                "name": "Домашній кавовий вермут",
                "cocktailCount": 1
            },
            {
                "id": 179,
                "name": "В'ялене м'ясо з медом акації",
                "cocktailCount": 1
            },
            {
                "id": 171,
                "name": "Домашня шавлієва вода",
                "cocktailCount": 1
            },
            {
                "id": 170,
                "name": "Солона кокосова карамель",
                "cocktailCount": 1
            },
            {
                "id": 169,
                "name": "Домашній сироп кола",
                "cocktailCount": 1
            },
            {
                "id": 168,
                "name": "Домашній ромовий мікс",
                "cocktailCount": 1
            },
            {
                "id": 167,
                "name": "Домашній банановий віскі",
                "cocktailCount": 1
            },
            {
                "id": 165,
                "name": "Домашній збагачений арахісовою пастою ром",
                "cocktailCount": 1
            },
            {
                "id": 163,
                "name": "Домашній яблучно-ревеневий кетчуп",
                "cocktailCount": 1
            },
            {
                "id": 162,
                "name": "Домашня горілка на соусі ворчестер",
                "cocktailCount": 1
            },
            {
                "id": 161,
                "name": "Домашній банановий джин",
                "cocktailCount": 1
            },
            {
                "id": 159,
                "name": "Домашній ванільний віскі",
                "cocktailCount": 1
            },
            {
                "id": 158,
                "name": "Домашній тютюновий сироп",
                "cocktailCount": 1
            },
            {
                "id": 156,
                "name": "Домашній індійський мікс",
                "cocktailCount": 1
            },
            {
                "id": 155,
                "name": "Домашній грейпфрутово-кроповий кордіал",
                "cocktailCount": 1
            },
            {
                "id": 154,
                "name": "Домашня горілка на кацуобусі",
                "cocktailCount": 1
            },
            {
                "id": 152,
                "name": "Домашня горілка на буряку",
                "cocktailCount": 1
            },
            {
                "id": 145,
                "name": "Черешня",
                "cocktailCount": 1
            },
            {
                "id": 140,
                "name": "Сушений фінік",
                "cocktailCount": 1
            },
            {
                "id": 139,
                "name": "Домашній червоний вермут з пеканом",
                "cocktailCount": 1
            },
            {
                "id": 138,
                "name": "Домашній збагачений маслом кокоса ром",
                "cocktailCount": 1
            },
            {
                "id": 137,
                "name": "Домашній збагачений маслом і бобами тонка коньяк",
                "cocktailCount": 1
            },
            {
                "id": 135,
                "name": "Обліпиховий сік",
                "cocktailCount": 1
            },
            {
                "id": 132,
                "name": "Сік алое",
                "cocktailCount": 1
            },
            {
                "id": 129,
                "name": "Сік квашеної капусти",
                "cocktailCount": 1
            },
            {
                "id": 128,
                "name": "Сухі квітки для чаю",
                "cocktailCount": 1
            },
            {
                "id": 123,
                "name": "Джері Томас бітер",
                "cocktailCount": 1
            },
            {
                "id": 122,
                "name": "Кумкватовий джем",
                "cocktailCount": 1
            },
            {
                "id": 120,
                "name": "Аґрусовий джем",
                "cocktailCount": 1
            },
            {
                "id": 118,
                "name": "Полуничний джем",
                "cocktailCount": 1
            },
            {
                "id": 115,
                "name": "Інжирний джем",
                "cocktailCount": 1
            },
            {
                "id": 114,
                "name": "Журавлинний джем з портвейном",
                "cocktailCount": 1
            },
            {
                "id": 108,
                "name": "Сироп маршмеллоу",
                "cocktailCount": 1
            },
            {
                "id": 106,
                "name": "Імбирний пряник",
                "cocktailCount": 1
            },
            {
                "id": 89,
                "name": "Селеровий джин",
                "cocktailCount": 1
            },
            {
                "id": 80,
                "name": "Рахат-лукум",
                "cocktailCount": 1
            },
            {
                "id": 70,
                "name": "Вершкове масло солоне",
                "cocktailCount": 1
            },
            {
                "id": 65,
                "name": "Сир Салерс",
                "cocktailCount": 1
            },
            {
                "id": 60,
                "name": "Чорний чай листовий",
                "cocktailCount": 1
            },
            {
                "id": 50,
                "name": "Кокос",
                "cocktailCount": 1
            },
            {
                "id": 45,
                "name": "Сичуанський бутон",
                "cocktailCount": 1
            },
            {
                "id": 44,
                "name": "Ламінарія",
                "cocktailCount": 1
            },
            {
                "id": 43,
                "name": "Батат",
                "cocktailCount": 1
            },
            {
                "id": 41,
                "name": "Пшенічний хліб",
                "cocktailCount": 1
            },
            {
                "id": 38,
                "name": "Дженевер з маракуйєю",
                "cocktailCount": 1
            },
            {
                "id": 33,
                "name": "Шисо",
                "cocktailCount": 1
            },
            {
                "id": 30,
                "name": "Перець-горошок",
                "cocktailCount": 1
            },
            {
                "id": 21,
                "name": "Настоянка з ароматом барбекю",
                "cocktailCount": 1
            },
            {
                "id": 20,
                "name": "Дабл рай віскі",
                "cocktailCount": 1
            },
            {
                "id": 8,
                "name": "Женьшень в капсулах",
                "cocktailCount": 1
            },
            {
                "id": 6,
                "name": "Мелений імбир",
                "cocktailCount": 1
            }
        ],
        "selectionType": "MULTIPLE"
    },
    {
        "id": 0,
        "queryName": "tags",
        "name": "Інше",
        "items": [
            {
                "id": 9,
                "name": "на горілці",
                "cocktailCount": 182
            },
            {
                "id": 23,
                "name": "тропічні",
                "cocktailCount": 153
            },
            {
                "id": 21,
                "name": "на ромі",
                "cocktailCount": 131
            },
            {
                "id": 17,
                "name": "на джині",
                "cocktailCount": 127
            },
            {
                "id": 18,
                "name": "шорти",
                "cocktailCount": 118
            },
            {
                "id": 5,
                "name": "лонги",
                "cocktailCount": 105
            },
            {
                "id": 3,
                "name": "на віскі",
                "cocktailCount": 94
            },
            {
                "id": 14,
                "name": "твісти",
                "cocktailCount": 90
            },
            {
                "id": 33,
                "name": "шоти",
                "cocktailCount": 84
            },
            {
                "id": 47,
                "name": "вершкові",
                "cocktailCount": 83
            },
            {
                "id": 32,
                "name": "на текілі",
                "cocktailCount": 82
            },
            {
                "id": 40,
                "name": "гіркі",
                "cocktailCount": 63
            },
            {
                "id": 31,
                "name": "на лікері",
                "cocktailCount": 61
            },
            {
                "id": 4,
                "name": "мікси",
                "cocktailCount": 51
            },
            {
                "id": 56,
                "name": "на коньяку",
                "cocktailCount": 48
            },
            {
                "id": 37,
                "name": "пікантні",
                "cocktailCount": 48
            },
            {
                "id": 15,
                "name": "фіззи",
                "cocktailCount": 47
            },
            {
                "id": 29,
                "name": "овочеві",
                "cocktailCount": 45
            },
            {
                "id": 27,
                "name": "прості",
                "cocktailCount": 45
            },
            {
                "id": 13,
                "name": "на ігристому",
                "cocktailCount": 41
            },
            {
                "id": 35,
                "name": "на бурбоні",
                "cocktailCount": 37
            },
            {
                "id": 66,
                "name": "сухі",
                "cocktailCount": 32
            },
            {
                "id": 54,
                "name": "квіткові",
                "cocktailCount": 32
            },
            {
                "id": 58,
                "name": "класичні",
                "cocktailCount": 31
            },
            {
                "id": 34,
                "name": "кава",
                "cocktailCount": 31
            },
            {
                "id": 24,
                "name": "сауери",
                "cocktailCount": 30
            },
            {
                "id": 49,
                "name": "коричневі",
                "cocktailCount": 27
            },
            {
                "id": 51,
                "name": "на вині",
                "cocktailCount": 21
            },
            {
                "id": 22,
                "name": "гарячі",
                "cocktailCount": 21
            },
            {
                "id": 46,
                "name": "на компанію",
                "cocktailCount": 20
            },
            {
                "id": 25,
                "name": "жовті",
                "cocktailCount": 19
            },
            {
                "id": 48,
                "name": "десерти",
                "cocktailCount": 19
            },
            {
                "id": 19,
                "name": "на вермуті",
                "cocktailCount": 19
            },
            {
                "id": 70,
                "name": "червоні",
                "cocktailCount": 17
            },
            {
                "id": 63,
                "name": "різнокольорові",
                "cocktailCount": 17
            },
            {
                "id": 41,
                "name": "театр",
                "cocktailCount": 17
            },
            {
                "id": 45,
                "name": "на соку",
                "cocktailCount": 16
            },
            {
                "id": 61,
                "name": "на кальвадосі",
                "cocktailCount": 15
            },
            {
                "id": 65,
                "name": "тіні",
                "cocktailCount": 12
            },
            {
                "id": 38,
                "name": "на самбуці",
                "cocktailCount": 11
            },
            {
                "id": 36,
                "name": "мартіні",
                "cocktailCount": 11
            },
            {
                "id": 42,
                "name": "бежеві",
                "cocktailCount": 10
            },
            {
                "id": 59,
                "name": "на содовій",
                "cocktailCount": 10
            },
            {
                "id": 39,
                "name": "на мескалю",
                "cocktailCount": 10
            },
            {
                "id": 74,
                "name": "на молоці",
                "cocktailCount": 9
            },
            {
                "id": 28,
                "name": "на пиві",
                "cocktailCount": 9
            },
            {
                "id": 71,
                "name": "оранжеві",
                "cocktailCount": 8
            },
            {
                "id": 67,
                "name": "он зе рокс",
                "cocktailCount": 8
            },
            {
                "id": 55,
                "name": "на газованій воді",
                "cocktailCount": 8
            },
            {
                "id": 53,
                "name": "на абсенті",
                "cocktailCount": 8
            },
            {
                "id": 78,
                "name": "прозорі",
                "cocktailCount": 6
            },
            {
                "id": 73,
                "name": "на піско",
                "cocktailCount": 6
            },
            {
                "id": 83,
                "name": "на саке",
                "cocktailCount": 5
            },
            {
                "id": 57,
                "name": "на кашасі",
                "cocktailCount": 5
            },
            {
                "id": 75,
                "name": "колінзи",
                "cocktailCount": 4
            },
            {
                "id": 52,
                "name": "маргарити",
                "cocktailCount": 4
            },
            {
                "id": 50,
                "name": "негроні",
                "cocktailCount": 4
            },
            {
                "id": 77,
                "name": "зелені",
                "cocktailCount": 3
            },
            {
                "id": 72,
                "name": "рожеві",
                "cocktailCount": 3
            },
            {
                "id": 62,
                "name": "моктейлі",
                "cocktailCount": 3
            },
            {
                "id": 26,
                "name": "тікі",
                "cocktailCount": 3
            },
            {
                "id": 69,
                "name": "фіолетові",
                "cocktailCount": 2
            },
            {
                "id": 79,
                "name": "олд-фешенди",
                "cocktailCount": 2
            },
            {
                "id": 64,
                "name": "дайкірі",
                "cocktailCount": 2
            },
            {
                "id": 103,
                "name": "білі",
                "cocktailCount": 1
            },
            {
                "id": 104,
                "name": "на араку",
                "cocktailCount": 1
            },
            {
                "id": 102,
                "name": "стірують",
                "cocktailCount": 1
            },
            {
                "id": 101,
                "name": "кайпірін'ї",
                "cocktailCount": 1
            },
            {
                "id": 80,
                "name": "сазеракі",
                "cocktailCount": 1
            },
            {
                "id": 76,
                "name": "гімлети",
                "cocktailCount": 1
            },
            {
                "id": 68,
                "name": "смузi",
                "cocktailCount": 1
            }
        ],
        "selectionType": "MULTIPLE"
    },
    {
        "id": 2,
        "queryName": "tools",
        "name": "Приладдя",
        "items": [
            {
                "id": 85,
                "name": "Джигер",
                "cocktailCount": 926
            },
            {
                "id": 386,
                "name": "Коктейльна ложка",
                "cocktailCount": 622
            },
            {
                "id": 14,
                "name": "Стрейнер",
                "cocktailCount": 521
            },
            {
                "id": 387,
                "name": "Прес для цитрусових",
                "cocktailCount": 477
            },
            {
                "id": 543,
                "name": "Трубочки",
                "cocktailCount": 442
            },
            {
                "id": 468,
                "name": "Шейкер",
                "cocktailCount": 435
            },
            {
                "id": 385,
                "name": "Мадлер",
                "cocktailCount": 212
            },
            {
                "id": 594,
                "name": "Рокс",
                "cocktailCount": 200
            },
            {
                "id": 74,
                "name": "Хайбол",
                "cocktailCount": 178
            },
            {
                "id": 62,
                "name": "Ситечко",
                "cocktailCount": 177
            },
            {
                "id": 323,
                "name": "Коктейльний келих",
                "cocktailCount": 154
            },
            {
                "id": 59,
                "name": "Ніж для цедри",
                "cocktailCount": 151
            },
            {
                "id": 379,
                "name": "Чарка",
                "cocktailCount": 132
            },
            {
                "id": 103,
                "name": "Коктейльна шпажка",
                "cocktailCount": 115
            },
            {
                "id": 280,
                "name": "Склянка для змішування",
                "cocktailCount": 95
            },
            {
                "id": 274,
                "name": "Шампанське блюдце",
                "cocktailCount": 75
            },
            {
                "id": 1052,
                "name": "Келих для ірландської кави",
                "cocktailCount": 51
            },
            {
                "id": 63,
                "name": "Блендер",
                "cocktailCount": 49
            },
            {
                "id": 1008,
                "name": "Слінг",
                "cocktailCount": 41
            },
            {
                "id": 293,
                "name": "Тертушка для мускату",
                "cocktailCount": 30
            },
            {
                "id": 235,
                "name": "Совок для льоду",
                "cocktailCount": 30
            },
            {
                "id": 1132,
                "name": "Колінз",
                "cocktailCount": 27
            },
            {
                "id": 1004,
                "name": "Пітчер",
                "cocktailCount": 27
            },
            {
                "id": 13,
                "name": "Пальник",
                "cocktailCount": 27
            },
            {
                "id": 1034,
                "name": "Флюте",
                "cocktailCount": 26
            },
            {
                "id": 1031,
                "name": "Келих для вина",
                "cocktailCount": 25
            },
            {
                "id": 496,
                "name": "Глечик",
                "cocktailCount": 25
            },
            {
                "id": 4,
                "name": "Кавомашина",
                "cocktailCount": 21
            },
            {
                "id": 78,
                "name": "Соковижималка",
                "cocktailCount": 19
            },
            {
                "id": 1019,
                "name": "Кубок",
                "cocktailCount": 19
            },
            {
                "id": 26,
                "name": "Харрікейн",
                "cocktailCount": 19
            },
            {
                "id": 1079,
                "name": "Чашка",
                "cocktailCount": 15
            },
            {
                "id": 321,
                "name": "Келих сауер",
                "cocktailCount": 15
            },
            {
                "id": 1102,
                "name": "Ножиці для перепелиних яєць",
                "cocktailCount": 12
            },
            {
                "id": 86,
                "name": "Спреєр",
                "cocktailCount": 10
            },
            {
                "id": 547,
                "name": "Коктейльна креманка",
                "cocktailCount": 9
            },
            {
                "id": 566,
                "name": "Мідний кухоль",
                "cocktailCount": 8
            },
            {
                "id": 378,
                "name": "Свізл стік",
                "cocktailCount": 8
            },
            {
                "id": 312,
                "name": "Чайна ложка",
                "cocktailCount": 8
            },
            {
                "id": 1119,
                "name": "Заварний чайник",
                "cocktailCount": 7
            },
            {
                "id": 1091,
                "name": "Тікі-келих",
                "cocktailCount": 7
            },
            {
                "id": 1101,
                "name": "Коньячний келих",
                "cocktailCount": 6
            },
            {
                "id": 548,
                "name": "Келих Маргарита",
                "cocktailCount": 6
            },
            {
                "id": 333,
                "name": "Таця",
                "cocktailCount": 6
            },
            {
                "id": 278,
                "name": "Бутель",
                "cocktailCount": 6
            },
            {
                "id": 1005,
                "name": "Миска",
                "cocktailCount": 5
            },
            {
                "id": 1117,
                "name": "Прищіпки",
                "cocktailCount": 4
            },
            {
                "id": 1017,
                "name": "Вінчик",
                "cocktailCount": 4
            },
            {
                "id": 1120,
                "name": "Блюдце",
                "cocktailCount": 3
            },
            {
                "id": 1037,
                "name": "Міксер для мілкшейків",
                "cocktailCount": 3
            },
            {
                "id": 1027,
                "name": "Крафт-папір",
                "cocktailCount": 3
            },
            {
                "id": 355,
                "name": "Саке сет",
                "cocktailCount": 3
            },
            {
                "id": 1069,
                "name": "Чаша для пуншу",
                "cocktailCount": 3
            },
            {
                "id": 1041,
                "name": "Серветки",
                "cocktailCount": 2
            },
            {
                "id": 47,
                "name": "Банка з кришкою",
                "cocktailCount": 2
            },
            {
                "id": 1025,
                "name": "Сифон",
                "cocktailCount": 2
            },
            {
                "id": 511,
                "name": "Слайсер для ананасу",
                "cocktailCount": 2
            },
            {
                "id": 384,
                "name": "Ложка для абсенту",
                "cocktailCount": 2
            },
            {
                "id": 1136,
                "name": "Френч-прес",
                "cocktailCount": 1
            },
            {
                "id": 1126,
                "name": "Обкурювач",
                "cocktailCount": 1
            },
            {
                "id": 396,
                "name": "Пінта",
                "cocktailCount": 1
            },
            {
                "id": 46,
                "name": "Сифон для кави",
                "cocktailCount": 1
            },
            {
                "id": 1097,
                "name": "Пательня",
                "cocktailCount": 1
            },
            {
                "id": 1063,
                "name": "Скляночка для чаю",
                "cocktailCount": 1
            },
            {
                "id": 1029,
                "name": "Скляний ковпак",
                "cocktailCount": 1
            },
            {
                "id": 615,
                "name": "Парасолька",
                "cocktailCount": 1
            },
            {
                "id": 583,
                "name": "Бубен",
                "cocktailCount": 1
            },
            {
                "id": 522,
                "name": "Калабас",
                "cocktailCount": 1
            },
            {
                "id": 450,
                "name": "Термометр",
                "cocktailCount": 1
            },
            {
                "id": 447,
                "name": "Дистилятор",
                "cocktailCount": 1
            },
            {
                "id": 64,
                "name": "Гумка",
                "cocktailCount": 1
            }
        ],
        "selectionType": "MULTIPLE"
    }
]"""


    fun getFilters(): List<FilterItem> {
        val gson = GsonBuilder().setLenient().create()
        GsonConverterFactory.create(gson)
        return gson.fromJson(jsonString, Filters::class.java)
    }

}






