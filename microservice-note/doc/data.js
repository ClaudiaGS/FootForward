db.getCollection('note').deleteMany({}) ;
//use note
db.note.insertMany([
{
    "_id" : 1,
    "patId" : 1,
    "Patient" : "Lucas Ferguson",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il «se sent très bien» Poids égal ou inférieur au poids recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 2,
    "patId" : 1,
    "Patient" : "Lucas Ferguson",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il se sent fatigué pendant la journée Il se plaint également de douleurs musculaires Tests de laboratoire indiquant une microalbumine élevée",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 3,
    "patId" : 1,
    "Patient" : "Lucas Ferguson",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il ne se sent pas si fatigué que ça Fumeur, il a arrêté dans les 12 mois précédents Tests de laboratoire indiquant que les anticorps sont élevés",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 4,
    "patId" : 2,
    "Patient" : "Pippa Rees",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il ressent beaucoup de stress au travail Il se plaint également que son audition est anormale dernièrement",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 5,
    "patId" : 2,
    "Patient" : "Pippa Rees",
    "Practitioner's notes/recommendations" :
    "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois Il remarque également que son audition continue d'être anormale",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 6,
    "patId" : 2,
    "Patient" : "Pippa Rees",
    "Practitioner's notes/recommendations" :
    "Tests de laboratoire indiquant une microalbumine élevée",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 7,
    "patId" : 2,
    "Patient" : "Pippa Rees",
    "Practitioner's notes/recommendations" :
    "Le patient déclare que tout semble aller bien Le laboratoire rapporte que l'hémoglobine A1C dépasse le niveau recommandé Le patient déclare qu’il fume depuis longtemps",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 8,
    "patId" : 3,
    "Patient" : "Edward Arnold",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il fume depuis peu",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 9,
    "patId" : 3,
    "Patient" : "Edward Arnold",
    "Practitioner's notes/recommendations" :
    "Tests de laboratoire indiquant une microalbumine élevée",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 10,
    "patId" : 3,
    "Patient" : "Edward Arnold",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière Il se plaint également de crises d’apnée respiratoire anormales Tests de laboratoire indiquant un taux de cholestérol LDL élevé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 11,
    "patId" : 3,
    "Patient" : "Edward Arnold",
    "Practitioner's notes/recommendations" :
    "Tests de laboratoire indiquant un taux de cholestérol LDL élevé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 12,
    "patId" : 4,
    "Patient" : "Anthony Sharp",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il lui est devenu difficile de monter les escaliers Il se plaint également d’être essoufflé Tests de laboratoire indiquant que les anticorps sont élevés Réaction aux médicaments",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 13,
    "patId" : 4,
    "Patient" : "Anthony Sharp",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 14,
    "patId" : 4,
    "Patient" : "Anthony Sharp",
    "Practitioner's notes/recommendations" :
    "Le patient déclare avoir commencé à fumer depuis peu Hémoglobine A1C supérieure au niveau recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 15,
    "patId" : 5,
    "Patient" : "Wendy Ince",
    "Practitioner's notes/recommendations" :
    "Le patient déclare avoir des douleurs au cou occasionnellement Le patient remarque également que certains aliments ont un goût différent Réaction apparente aux médicaments Poids corporel supérieur au poids recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 16,
    "patId" : 5,
    "Patient" : "Wendy Ince",
    "Practitioner's notes/recommendations" :
    "Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite. Taille incluse dans la fourchette concernée",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 17,
    "patId" : 5,
    "Patient" : "Wendy Ince",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il souffre encore de douleurs cervicales occasionnelles Tests de laboratoire indiquant une microalbumine élevée Fumeur, il a arrêté dans les 12 mois précédents",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 18,
    "patId" : 5,
    "Patient" : "Wendy Ince",
    "Practitioner's notes/recommendations" :
    "Le patient déclare avoir eu plusieurs épisodes de vertige depuis la dernière visite. Tests de laboratoire indiquant que les anticorps sont élevés",
    "_class" : "com.footforward.microservicenote.domain.Note"
},

{
    "_id" : 19,
    "patId" : 6,
    "Patient" : "Tracey Ross",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il se sent bien Poids corporel supérieur au poids recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 20,
    "patId" : 6,
    "Patient" : "Tracey Ross",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il se sent bien",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 21,
    "patId" : 7,
    "Patient" : "Claire Wilson",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il se réveille souvent avec une raideur articulaire Il se plaint également de difficultés pour s’endormir Poids corporel supérieur au poids recommandé Tests de laboratoire indiquant un taux de cholestérol LDL élevé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 22,
    "patId" : 8,
    "Patient" : "Max Buckland",
    "Practitioner's notes/recommendations" :
    "Les tests de laboratoire indiquent que les anticorps sont élevés Hémoglobine A1C supérieure au niveau recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 23,
    "patId" : 9,
    "Patient" : "Natalie Clark",
    "Practitioner's notes/recommendations" :
    "Le patient déclare avoir de la difficulté à se concentrer sur ses devoirs scolaires Hémoglobine A1C supérieure au niveau recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 24,
    "patId" : 9,
    "Patient" : "Natalie Clark",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il s’impatiente facilement en cas d’attente prolongée Il signale également que les produits du distributeur automatique ne sont pas bons Tests de laboratoire signalant des taux anormaux de cellules sanguines",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 25,
    "patId" : 9,
    "Patient" : "Natalie Clark",
    "Practitioner's notes/recommendations" :
    "Le patient signale qu'il est facilement irrité par des broutilles Il déclare également que l'aspirateur des voisins fait trop de bruit Tests de laboratoire indiquant que les anticorps sont élevés",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 26,
    "patId" : 10,
    "Patient" : "Piers Bailey",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il n'a aucun problème",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 27,
    "patId" : 10,
    "Patient" : "Piers Bailey",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il n'a aucun problème Taille incluse dans la fourchette concernée Hémoglobine A1C supérieure au niveau recommandé",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 28,
    "patId" : 10,
    "Patient" : "Piers Bailey",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il n'a aucun problème Poids corporel supérieur au poids recommandé Le patient a signalé plusieurs épisodes de vertige depuis sa dernière visite",
    "_class" : "com.footforward.microservicenote.domain.Note"
},
{
    "_id" : 29,
    "patId" : 10,
    "Patient" : "Piers Bailey",
    "Practitioner's notes/recommendations" :
    "Le patient déclare qu'il n'a aucun problème Tests de laboratoire indiquant une microalbumine élevée",
    "_class" : "com.footforward.microservicenote.domain.Note"
}
])
