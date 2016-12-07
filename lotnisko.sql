-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Lis 2016, 00:40
-- Wersja serwera: 10.1.16-MariaDB
-- Wersja PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `lotnisko`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `bagaz_przylatujacy`
--

CREATE TABLE `bagaz_przylatujacy` (
  `id_bagazu` int(11) NOT NULL,
  `id_rezerwacji` int(11) NOT NULL,
  `waga` float NOT NULL,
  `status_bagazu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `bagaz_przylatujacy`
--

INSERT INTO `bagaz_przylatujacy` (`id_bagazu`, `id_rezerwacji`, `waga`, `status_bagazu`) VALUES
(2, 124, 124, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `bagaz_wylatujacy`
--

CREATE TABLE `bagaz_wylatujacy` (
  `id_bagazu` int(11) NOT NULL,
  `id_rezerwacji` int(11) NOT NULL,
  `waga` float NOT NULL,
  `czy_potrzebna_doplata` tinyint(1) NOT NULL,
  `doplata` int(11) NOT NULL,
  `cena_za_kg` int(11) NOT NULL,
  `czy_przeszedl_odprawe` tinyint(1) NOT NULL,
  `czy_oplacono_bagaz` tinyint(1) NOT NULL,
  `status_bagazu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dzialy`
--

CREATE TABLE `dzialy` (
  `id_dzialu` int(11) NOT NULL,
  `nazwa` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `identyfikatory`
--

CREATE TABLE `identyfikatory` (
  `id_identyfikatora` int(11) NOT NULL,
  `numer` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `typ` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `identyfikatory`
--

INSERT INTO `identyfikatory` (`id_identyfikatora`, `numer`, `typ`) VALUES
(1, 'AVK41547815', 'Paszport'),
(2, 'AQW457845', 'Paszport'),
(3, 'Add457155', 'Dowód osobisty'),
(4, 'QWsz12521', 'Dowód osobisty'),
(5, 'Azxv45184', 'Dowód osobisty');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klienci`
--

CREATE TABLE `klienci` (
  `id` int(11) NOT NULL,
  `imie` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `id_identyfikatora` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `klienci`
--

INSERT INTO `klienci` (`id`, `imie`, `nazwisko`, `id_identyfikatora`) VALUES
(1, 'Testowy', 'Janusz', 1),
(2, 'Adam', 'Małysz', 2),
(3, 'Zbigniew', 'Ciasny', 4),
(4, 'Jakub', 'Krysiak', 5),
(5, 'Jan', 'Nowak', 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `listamiejscparkingowych`
--

CREATE TABLE `listamiejscparkingowych` (
  `id` int(11) NOT NULL,
  `numer` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `loty`
--

CREATE TABLE `loty` (
  `id` int(11) NOT NULL,
  `miejsce_wylotu` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `miejsce_przylotu` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `data_przylotu` date NOT NULL,
  `data_odlotu` date NOT NULL,
  `stan` int(11) NOT NULL,
  `id_samolotu` int(11) NOT NULL,
  `bramka` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `loty`
--

INSERT INTO `loty` (`id`, `miejsce_wylotu`, `miejsce_przylotu`, `data_przylotu`, `data_odlotu`, `stan`, `id_samolotu`, `bramka`) VALUES
(1, 'warszawa', 'moskwa', '2016-11-01', '2016-11-10', 2, 1, 231),
(2, 'łódź', 'kraków', '2016-11-01', '2016-11-01', 1, 2, 1512),
(3, 'moskwa', 'warszawa', '2016-10-03', '2016-11-08', 1, 4, 214),
(4, 'warszawa', 'moskwa', '2016-12-01', '2016-12-01', 2, 4, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `modelesamolotow`
--

CREATE TABLE `modelesamolotow` (
  `id_modelu` int(11) NOT NULL,
  `calkowita_masa_podreczna` int(11) NOT NULL,
  `calkowita_masa_bagazu` int(11) NOT NULL,
  `ilosc_miejsc` int(11) NOT NULL,
  `nazwa` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `modelesamolotow`
--

INSERT INTO `modelesamolotow` (`id_modelu`, `calkowita_masa_podreczna`, `calkowita_masa_bagazu`, `ilosc_miejsc`, `nazwa`) VALUES
(1, 20, 30, 150, 'Tupolew'),
(2, 22, 32, 128, 'Boeling 737'),
(3, 30, 50, 80, 'MiniSamolot');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownicy`
--

CREATE TABLE `pracownicy` (
  `id_pracownika` int(11) NOT NULL,
  `imie` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `stanowisko` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `id_dzialu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rezerwacje`
--

CREATE TABLE `rezerwacje` (
  `id_rezerwacji` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `id_lotu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `samoloty`
--

CREATE TABLE `samoloty` (
  `id_samolotu` int(11) NOT NULL,
  `id_modelu` int(11) NOT NULL,
  `status_samolotu` tinyint(1) NOT NULL,
  `miejsce_parkowania_samolotu` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `samoloty`
--

INSERT INTO `samoloty` (`id_samolotu`, `id_modelu`, `status_samolotu`, `miejsce_parkowania_samolotu`) VALUES
(1, 1, 1, '234'),
(2, 2, 2, '421');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `status_bagazu`
--

CREATE TABLE `status_bagazu` (
  `id_statusu` int(11) NOT NULL,
  `czy_bomba` tinyint(1) NOT NULL,
  `czy_dostarczony_do_samolotu` tinyint(1) NOT NULL,
  `czy_jest_w_samolocie` tinyint(1) NOT NULL,
  `czy_na_tasmie` tinyint(1) NOT NULL,
  `czy_zabrany_z_tasmy` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `status_bagazu`
--

INSERT INTO `status_bagazu` (`id_statusu`, `czy_bomba`, `czy_dostarczony_do_samolotu`, `czy_jest_w_samolocie`, `czy_na_tasmie`, `czy_zabrany_z_tasmy`) VALUES
(1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zadania`
--

CREATE TABLE `zadania` (
  `id_zadania` int(11) NOT NULL,
  `poczatek_zadania` date NOT NULL,
  `koniec_zadania` date NOT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `id_pracownika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zarezerwowanemiejsca`
--

CREATE TABLE `zarezerwowanemiejsca` (
  `id` int(11) NOT NULL,
  `id_samolotu` int(11) NOT NULL,
  `id_miejsca` int(11) NOT NULL,
  `id_rezerwacji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zgloszenia`
--

CREATE TABLE `zgloszenia` (
  `id_zgloszenia` int(11) NOT NULL,
  `data_zgloszenia` date NOT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `bagaz_przylatujacy`
--
ALTER TABLE `bagaz_przylatujacy`
  ADD PRIMARY KEY (`id_bagazu`),
  ADD KEY `status_bagazu` (`status_bagazu`);

--
-- Indexes for table `bagaz_wylatujacy`
--
ALTER TABLE `bagaz_wylatujacy`
  ADD PRIMARY KEY (`id_bagazu`),
  ADD KEY `status_bagazu` (`status_bagazu`);

--
-- Indexes for table `dzialy`
--
ALTER TABLE `dzialy`
  ADD PRIMARY KEY (`id_dzialu`);

--
-- Indexes for table `identyfikatory`
--
ALTER TABLE `identyfikatory`
  ADD PRIMARY KEY (`id_identyfikatora`);

--
-- Indexes for table `klienci`
--
ALTER TABLE `klienci`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_identyfikatora` (`id_identyfikatora`);

--
-- Indexes for table `listamiejscparkingowych`
--
ALTER TABLE `listamiejscparkingowych`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loty`
--
ALTER TABLE `loty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modelesamolotow`
--
ALTER TABLE `modelesamolotow`
  ADD PRIMARY KEY (`id_modelu`);

--
-- Indexes for table `pracownicy`
--
ALTER TABLE `pracownicy`
  ADD PRIMARY KEY (`id_pracownika`);

--
-- Indexes for table `rezerwacje`
--
ALTER TABLE `rezerwacje`
  ADD PRIMARY KEY (`id_rezerwacji`);

--
-- Indexes for table `samoloty`
--
ALTER TABLE `samoloty`
  ADD PRIMARY KEY (`id_samolotu`),
  ADD KEY `id_modelu` (`id_modelu`);

--
-- Indexes for table `status_bagazu`
--
ALTER TABLE `status_bagazu`
  ADD PRIMARY KEY (`id_statusu`);

--
-- Indexes for table `zadania`
--
ALTER TABLE `zadania`
  ADD PRIMARY KEY (`id_zadania`);

--
-- Indexes for table `zarezerwowanemiejsca`
--
ALTER TABLE `zarezerwowanemiejsca`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zgloszenia`
--
ALTER TABLE `zgloszenia`
  ADD PRIMARY KEY (`id_zgloszenia`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `bagaz_przylatujacy`
--
ALTER TABLE `bagaz_przylatujacy`
  MODIFY `id_bagazu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `bagaz_wylatujacy`
--
ALTER TABLE `bagaz_wylatujacy`
  MODIFY `id_bagazu` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `dzialy`
--
ALTER TABLE `dzialy`
  MODIFY `id_dzialu` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `identyfikatory`
--
ALTER TABLE `identyfikatory`
  MODIFY `id_identyfikatora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `klienci`
--
ALTER TABLE `klienci`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `listamiejscparkingowych`
--
ALTER TABLE `listamiejscparkingowych`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `loty`
--
ALTER TABLE `loty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `modelesamolotow`
--
ALTER TABLE `modelesamolotow`
  MODIFY `id_modelu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT dla tabeli `pracownicy`
--
ALTER TABLE `pracownicy`
  MODIFY `id_pracownika` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `rezerwacje`
--
ALTER TABLE `rezerwacje`
  MODIFY `id_rezerwacji` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `samoloty`
--
ALTER TABLE `samoloty`
  MODIFY `id_samolotu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `status_bagazu`
--
ALTER TABLE `status_bagazu`
  MODIFY `id_statusu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT dla tabeli `zadania`
--
ALTER TABLE `zadania`
  MODIFY `id_zadania` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `zarezerwowanemiejsca`
--
ALTER TABLE `zarezerwowanemiejsca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `zgloszenia`
--
ALTER TABLE `zgloszenia`
  MODIFY `id_zgloszenia` int(11) NOT NULL AUTO_INCREMENT;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `bagaz_przylatujacy`
--
ALTER TABLE `bagaz_przylatujacy`
  ADD CONSTRAINT `aa` FOREIGN KEY (`status_bagazu`) REFERENCES `status_bagazu` (`id_statusu`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `bagaz_wylatujacy`
--
ALTER TABLE `bagaz_wylatujacy`
  ADD CONSTRAINT `bb` FOREIGN KEY (`status_bagazu`) REFERENCES `status_bagazu` (`id_statusu`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `klienci`
--
ALTER TABLE `klienci`
  ADD CONSTRAINT `kid` FOREIGN KEY (`id_identyfikatora`) REFERENCES `identyfikatory` (`id_identyfikatora`) ON DELETE SET NULL;

--
-- Ograniczenia dla tabeli `samoloty`
--
ALTER TABLE `samoloty`
  ADD CONSTRAINT `sm` FOREIGN KEY (`id_modelu`) REFERENCES `modelesamolotow` (`id_modelu`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
