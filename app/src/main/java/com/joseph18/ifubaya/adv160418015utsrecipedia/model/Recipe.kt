package com.joseph18.ifubaya.adv160418015utsrecipedia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Recipe
    (
        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "photoUrl")
        var photoUrl: String,
    ) {

    @PrimaryKey(autoGenerate = true)
    var uuid :Int = 0

    companion object {

        fun getMockRecipes(): ArrayList<Recipe> {
            var recipes = ArrayList<Recipe>()

            var id = 0;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Adeptus' Temptation",
                    description = "A complex, famous type of Liyue cuisine, in which specially selected ingredients are submerged and slowly bowled into soup stock. The recipe scribbled from memory alone was enough to urge the adepti to once again return to the world of men.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/5/5e/Item_Adeptus%27_Temptation.png/revision/latest/scale-to-width-down/256?cb=20210415133724",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Almond Tofu",
                    description = "A dessert made out of almond. It has a silky-smooth texture with a long-lasting aroma of almond. It's named tofu only because of its tofu-like shape.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/5/5f/Item_Almond_Tofu.png/revision/latest/scale-to-width-down/256?cb=20210216225709",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Apple Cider",
                    description = "A freshly squeezed, fashionable, and fruity non-alcoholic beverage. Said to have a strong sobering effect, tavern patrons often order this as the last drink of the night.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/c/c3/Item_Apple_Cider.png/revision/latest/scale-to-width-down/256?cb=20201126235210",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Bamboo Shoot Soup",
                    description = "A soup dish that's been stewed for a good long while. The meat and ham have been diced into small pieces, and the soup has been kept on low heat till it turned milky white. The process has brought out the distinct flavors of both kinds of meat, making for an especially tasty soup.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/9/9d/Item_Bamboo_Shoot_Soup.png/revision/latest/scale-to-width-down/256?cb=20210417152640",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Barbatos Ratatouille",
                    description = "A simple chowder with a long history. The ingredients are similarly traditional and simple. No matter where you are, a piping-hot chowder of this sort can always give you a sense of real and unsurpassed satisfaction.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/a/a3/Item_Barbatos_Ratatouille.png/revision/latest/scale-to-width-down/256?cb=20210415134134",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Berry & Mint Burst",
                    description = "A freshly squeezed, fashionable, and fruity non-alcoholic beverage. A refreshing burst of Mint with Berries to sweeten the deal, it has an exquisite aroma.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/b/bc/Item_Berry_%26_Mint_Burst.png/revision/latest/scale-to-width-down/256?cb=20201126235056",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Bird Egg Sushi",
                    description = "An everyday Inazuman dish. The sliced Egg Roll is placed over seasoned rice. Simply made, yet full of flavor.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/1/1d/Item_Bird_Egg_Sushi.png/revision/latest/scale-to-width-down/256?cb=20210901042636",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Black-Back Perch Stew",
                    description = "A poached fish dish. The fresh and tasty fish fillets are tender and juicy. The secret to this recipe is adding powdered Violetgrass into the heated oil to give the dish that aromatic scent. It's spicy, but not too spicy.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/3/31/Item_Black-Back_Perch_Stew.png/revision/latest/scale-to-width-down/256?cb=20210416221152",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Braised Meat",
                    description = "A stewed dish. The meat slices were fried first, followed by the vegetable accouterments, after which they were mixed together. The soup was then added and simmered until it thickened. After this patient, slow cooking process, the meat has become soft and tender, bringing those who eat it a down-to-earth satisfaction.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/8/84/Item_Braised_Meat.png/revision/latest/scale-to-width-down/256?cb=20211004223751",
                )
            ); id += 1;
            recipes.add(
                Recipe(
                    //id = id,
                    name = "Butter Crab",
                    description = "A grilled crab dish. Appropriate heat control has allowed the crab meat to stay moist and fatty. The butter has seeped into the crab meat, producing an aroma that has people salivating even from afar.",
                    photoUrl = "https://static.wikia.nocookie.net/gensin-impact/images/d/d6/Item_Butter_Crab.png/revision/latest/scale-to-width-down/256?cb=20210723024717",
                )
            ); id += 1;

            return recipes;
        }
    }
}