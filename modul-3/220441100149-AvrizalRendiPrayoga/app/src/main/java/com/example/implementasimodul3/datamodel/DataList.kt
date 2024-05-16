package com.example.implementasimodul3.datamodel

import com.example.implementasimodul3.R

object DataList {
    val places = listOf<PlaceModel>(
        PlaceModel(
            "Gunung Bromo",
            "Probolinggo",
            "Gunung Bromo adalah salah satu gunung berapi paling terkenal di Indonesia dan destinasi wisata yang populer di Jawa Timur. Pemandangan kawah yang spektakuler, padang pasir, serta suasana pagi yang magis membuat Gunung Bromo menjadi tujuan favorit para pendaki dan pengunjung.",
            R.drawable.bromo),

        PlaceModel(
            "Pantai Balekambang",
            "Malang",
            "Pantai Balekambang adalah salah satu pantai eksotis di Jawa Timur dengan keindahan alam yang menakjubkan. Pantai ini terkenal dengan tiga pulau kecil yang berdiri di tengah laut, di mana pengunjung dapat menikmati pasir putih, ombak yang tenang, dan keindahan panorama laut.",
            R.drawable.balekambang),

        PlaceModel(
            "Taman Safari Prigen",
            "Pasuruan",
            "Taman Safari Prigen adalah tempat wisata keluarga yang menawarkan pengalaman melihat berbagai satwa liar dari berbagai belahan dunia. Pengunjung dapat menjelajahi area safari dengan mobil atau bus, serta menikmati pertunjukan satwa dan wahana lainnya.",
            R.drawable.tamansafari),

        PlaceModel(
            "Air Terjun Madakaripura",
            "Probolinggo",
            "Air Terjun Madakaripura adalah air terjun tertinggi di Jawa Timur yang terkenal karena keindahannya. Terletak di dalam kawasan Taman Nasional Bromo Tengger Semeru, air terjun ini dikelilingi oleh tebing tinggi dan hamparan hijau yang memukau.",
            R.drawable.airterjun),

        PlaceModel(
            "Kawah Ijen",
            "Banyuwangi",
            "Kawah Ijen adalah salah satu kawah terkenal di Indonesia yang terkenal dengan fenomena Blue Fire (api biru) yang langka. Kawah ini juga memiliki danau asam yang terkenal dengan air berwarna biru. Pendakian menuju kawah ini menawarkan pemandangan alam yang menakjubkan.",
            R.drawable.kawahijen)
    )

    val hotels = listOf<HotelModel>(
        HotelModel(
            "Hotel Majapahit",
            1200,
            4.8,
            "Hotel bersejarah yang terletak di Surabaya, dengan arsitektur kolonial yang megah. Hotel ini menawarkan fasilitas mewah seperti spa, kolam renang, dan beberapa restoran kelas atas. Hotel Majapahit dikenal dengan suasana elegan dan pelayanan yang luar biasa, serta merupakan salah satu landmark bersejarah di kota Surabaya.",
            R.drawable.majapahit),

        HotelModel(
            "JW Marriott",
            1500,
            4.7,
            "Hotel bintang lima ini memiliki kamar-kamar modern yang dilengkapi dengan berbagai fasilitas unggulan. Terdapat pusat kebugaran, beberapa restoran, dan kolam renang outdoor. JW Marriott Surabaya terkenal dengan pelayanan yang ramah dan profesional, menjadikannya pilihan populer untuk pelancong bisnis dan wisatawan.",
            R.drawable.jwmarriot),

        HotelModel(
            "Hotel Tugu",
            800,
            4.6,
            "Hotel ini menawarkan pengalaman menginap yang unik dengan dekorasi klasik yang memadukan budaya Jawa dan kolonial. Hotel Tugu Malang memberikan suasana artistik dan berkelas dengan berbagai fasilitas, termasuk restoran tematik dan koleksi seni yang mengesankan.",
            R.drawable.hotel_tugu),

        HotelModel(
            "Bumi Surabaya",
            1200,
            4.5,
            "Sebuah hotel resor yang terletak di tengah kota Surabaya, dikelilingi oleh taman yang luas dan asri. Hotel ini menyediakan kamar-kamar yang nyaman, serta berbagai fasilitas rekreasi dan bisnis, membuatnya cocok untuk pelancong keluarga maupun korporat.",
            R.drawable.bumi_city_resort),

        HotelModel(
            "Plataran Bromo",
            1000,
            4.9,
            "Resort eksklusif di kawasan Bromo yang menawarkan pemandangan alam yang indah. Plataran Bromo menyediakan fasilitas lengkap seperti trekking guide, spa, dan restoran yang menyajikan hidangan lokal. Resort ini ideal untuk wisatawan yang mencari ketenangan dan petualangan.",
            R.drawable.plataran_bromo),

        HotelModel(
            "Swiss-Belinn",
            700,
            4.3,
            "Hotel bisnis modern yang terletak strategis di Malang. Menawarkan kamar-kamar nyaman, kolam renang, dan restoran yang menyajikan berbagai menu internasional dan lokal. Swiss-Belinn Malang adalah pilihan tepat untuk pelancong bisnis maupun liburan.",
            R.drawable.swiss_belinn),

        HotelModel(
            "Grand Mercure",
            1100,
            4.4,
            "Hotel bintang empat dengan desain kontemporer, menawarkan berbagai fasilitas seperti kolam renang, spa, dan pusat kebugaran. Terletak di area strategis Malang, hotel ini sangat cocok untuk wisatawan maupun pelancong bisnis yang mencari kenyamanan modern.",
            R.drawable.grand_mercure),

        HotelModel(
            "Singgasana Hotel",
            950,
            4.2,
            "Hotel yang menawarkan suasana tenang dan alami dengan fasilitas seperti kolam renang, lapangan tenis, dan beberapa pilihan tempat makan. Singgasana Hotel Surabaya adalah tempat yang tepat untuk relaksasi di tengah kota.",
            R.drawable.singgasana),

        HotelModel(
            "Harris Hotel",
            600,
            4.5,
            "Hotel modern yang dilengkapi dengan fasilitas konvensi lengkap, kolam renang, pusat kebugaran, dan restoran yang menyajikan berbagai masakan internasional. Hotel ini menjadi pilihan utama untuk acara bisnis dan konvensi di Malang.",
            R.drawable.harris_hotel),

        HotelModel(
            "Novotel Samator",
            900,
            4.3,
            "Hotel bisnis dengan fasilitas lengkap, termasuk kolam renang, pusat kebugaran, dan beberapa restoran. Terletak di kawasan bisnis Surabaya Timur, Novotel Samator adalah pilihan ideal untuk pelancong bisnis yang mencari kenyamanan dan efisiensi.",
            R.drawable.samator),

        HotelModel(
            "Aston Banyuwangi Hotel",
            800,
            4.5,
            "Hotel modern di Banyuwangi yang menawarkan fasilitas lengkap untuk pelancong bisnis dan wisatawan. Dilengkapi dengan ruang konferensi, kolam renang, dan restoran dengan menu internasional dan lokal. Aston Banyuwangi terkenal dengan pelayanan ramah dan profesional.",
            R.drawable.aston),

        HotelModel(
            "Golden Tulip",
            750,
            4.6,
            "Resort mewah di Batu yang menawarkan pemandangan pegunungan yang menakjubkan. Dilengkapi dengan berbagai fasilitas seperti kolam renang, spa, dan restoran. Golden Tulip Holland Resort Batu adalah pilihan tepat untuk liburan keluarga dan wisata alam.",
            R.drawable.golden_tulip)
        )
}