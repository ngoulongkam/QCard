package com.example.qcard

class RevisionContent {

    val listOfLegislationContent = listOf(
        WordDescription("Animal Welfare Act 2006", "Effective from April 2007 in England and Wales, SECTION 9 places a duty of care on owner/keeper of animal to ensure they take reasonable steps to meet all animal welfare needs. Owner/ keeper must be over 16 years of age. Applies to all vertebrate animals, does not apply to an animal whilst in foetal or embryonic form. If Owner/keeper not complying, then fined up to £20,000, and 5- year imprisonment."),
        WordDescription("Animal Welfare Act 2006 5 welfare needs", "suitable environment, suitable diet, to exhibit normal behaviour patterns, to be housed with, or apart from other animals, to be protected from pain, suffering, injury, and disease."),
        WordDescription("Animal, Plant and Health Agency (APHA)", "Executive agency of DEFRA, working to safeguard animal & plant health for benefit of people, environment, and economy."),
        WordDescription("Department for Environment, Food and Rural Affairs (DEFRA)", "Government department, responsible for policies & regulations on the environment, food, and economy. Codes of practice for welfare of a Dog, Cat, Horse, Pony, Horse, non-human primates, and farm species is developed by DEFRA."),
        WordDescription("Animal Health and Welfare Board for England (AHWBE)", "Principal source of departmental advice to DEFRA ministers on all strategic health & welfare matters to kept animals in England. Has strategic oversight on DEFRA policy in relation to:\nAnimal health & welfare \nPublic health implications of animal diseases that fall within DEFRA remit.\nTransmissions of disease through zoonosis"),
        WordDescription("Veterinary Medicines Directive (VMD)", "The use of veterinary medicine is governed by VMD on behalf of DEFRA\nAim to safeguard public health, animal health & environment\nEnsure safety, quality, efficacy of medicines in the UK\nThey operate the licensing system for animal medicines\nAnimal health & welfare \nPublic health implications of animal diseases that fall within DEFRA remit.\nTransmissions of disease through zoonosis"),
        WordDescription("Veterinary Medicines Regulations 2013 (Effective from 1.10.13)", "Covers reporting of adverse effects of drugs, choice of medicines under the prescribing cascade\nStorage of medicines and responsible for assessment of patient’s health & diagnosis.\nStates who’s allowed to prescribe or supply each drug category e.g.\nPOM-V: prescription only medicine-veterinarian\nPOM-VPS:prescription only medicine-veterinarian, pharmacist, suitable qualified person.\nNFA-VPS:Non-food-animal-veterinarian, pharmacist, suitably qualified person\nAVM-GSL:authorised veterinary medicine-general sales list."),
        WordDescription("Zoo Licensing Act 1981", "Requires inspection & licensing of all zoos in GB aiming to ensure all animals kept in enclosures are provided with suitable environment and can express natural behaviours.\nSECTION 1: premises not a pet shop or circus open more than 7 days or 7 days in a 12-month period need a license, applied at the local authority.\nZoos must educate visitors about biodiversity, undertake conservation work, if appropriate do captive breeding, repopulation, or reintroduction of species into the wild.\nProvide info on captive species e.g., natural habitats\nPrevent the escaping of species, putting measures in place in case of escapees\nKeep records of natality, mortality, disposal and escapes of animals and their health\nZoos have an obligation to ensure good welfare, prevent vermin & pests from entering enclosures."),
    )

    val yearOneListOfSubject = listOf(
        SubjectDescription("Legislation", listOfLegislationContent)
    )

    val yearTwoListOfSubject = listOf(
        SubjectDescription("TBD", listOfLegislationContent)
    )

    val yearThreeListOfSubject = listOf(
        SubjectDescription("TBD", listOfLegislationContent)
    )

    val listOfYears = listOf(
        Year("1st Year", yearOneListOfSubject),
        Year("2nd Year", yearTwoListOfSubject),
        Year("3rd Year", yearThreeListOfSubject)
    )

    data class WordDescription(
        val word: String,
        val desc: String
    )

    data class SubjectDescription(
        val subject: String,
        val content: List<WordDescription>
    )

    data class Year(
        val year: String,
        val subject: List<SubjectDescription>
    )
}