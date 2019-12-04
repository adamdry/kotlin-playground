package variance

open class Organism(
    open val name: String,
    open val isAlive: Boolean)

open class Mammal(
    override val name: String,
    override val isAlive: Boolean,
    open val isFurry: Boolean) : Organism(name, isAlive)

class Human(
    override val name: String,
    override val isAlive: Boolean,
    val nationalInsuranceNum: String) : Mammal(name, isAlive, false)

class ListPlusPlus<T> {

    private val internalList: MutableList<T> = mutableListOf()

    fun addItem(item: T) {
        internalList.add(item)
    }

    fun getItem(index: Int): T {
        return internalList[index]
    }

}

class ListPlusPlusOut<out T> {

    private val internalList: MutableList<T> = mutableListOf()

//    fun addItem(item: T) {
//        internalList.add(item)
//    }

    fun getItem(index: Int): T {
        return internalList[index]
    }

}

class ListPlusPlusIn<in T> {

    private val internalList: MutableList<T> = mutableListOf()

    fun addItem(item: T) {
        internalList.add(item)
    }

//    fun getItem(index: Int): T {
//        return internalList[index]
//    }

}

class VarianceTest {

    companion object {

        // out
        fun covarianceExample() {

            val mamList: ListPlusPlusOut<Mammal> = ListPlusPlusOut<Mammal>()
            // all mammals are organisms - allowed
            val orgList: ListPlusPlusOut<Organism> = mamList
            // this is an OUT list - all mammals aren't Humans, so you can't cast this to a list of Humans
            //val humList: ListPlusPlusOut<Human> = mamList
        }

        // in
        fun contravarianceExample() {

            val mamList: ListPlusPlusIn<Mammal> = ListPlusPlusIn<Mammal>()
            // this is an IN list - all organisms aren't mammals, you can't be passing organisms that aren't
            //  mammals into a list of mammals
            //val orgList: ListPlusPlusIn<Organism> = mamList
            // all humans are mammals, feel free to pass humans into a list of mammals
            val humList: ListPlusPlusIn<Human> = mamList
        }

        // in and out
        fun invarianceExample() {

            val mamList: ListPlusPlus<Mammal> = ListPlusPlus<Mammal>()

            // can't do either of these, it's mammals all the way down
            // val orgList: ListPlusPlus<Organism> = mamList
            // val humList: ListPlusPlus<Human> = mamList

        }

//
//        fun runTests() {
//
//            example2()
//            covarianceExample()
//
//            val org1 = Organism("Dave(Org)", isAlive = true)
//            val mam1 = Mammal("Tim(Mam)", isAlive = true, isFurry = false)
//            val hum1 = Human("Grumio(Hum)", isAlive = true, nationalInsuranceNum = "123")
//
//            println("ORG LIST TESTS")
//            println("")
//
//            val orgList: MutableList<Organism> = mutableListOf(org1, mam1)
//
//            orgList.forEach {org ->
//                println("orgList Name ${org.name}")
//                println("orgList IsAlive? ${org.isAlive}")
//                // can't access the isFurry prop on the mam1 object - everything is an Organism
//            }
//
//
//            println("")
//            println("")
//            println("MAM LIST TESTS")
//            println("")
//
//            // this doesn't build
//            //Type inference failed. Expected type mismatch:
//            //required:
//            //MutableList<Mammal>
//            //found:
//            //MutableList<Organism>
//
//            //val mamList: MutableList<Mammal> = mutableListOf(org1, mam1)
//
//
//            // this also doesn't build - same error
//            //Type inference failed. Expected type mismatch:
//            //required:
//            //MutableList<out Mammal>
//            //found:
//            //MutableList<Organism>
//
//            //val mamList2: List<Mammal> = listOf(mam1, org1)
//
//            val mamList: MutableList<out Mammal> = mutableListOf(mam1)
//
//            mamList.forEach {mam ->
//                println("mamList Name ${mam.name}")
//                println("mamList IsAlive? ${mam.isAlive}")
//                println("mamList isFurry? ${mam.isFurry}")
//            }
//
////            val mamList: MutableList<in Mammal> = mutableListOf(org1, mam1, "blah")
////
////            mamList.forEach {mam ->
////                println("mamList Name ${mam.name}")
////                println("mamList IsAlive? ${mam.isAlive}")
////                println("mamList isFurry? ${mam.isFurry}")
////            }
//        }
//
//        fun covarianceExample() {
//
//            val mam1 = Mammal("Tim(Mam)", isAlive = true, isFurry = false)
//            val mam2 = Mammal("Jeff(Mam)", isAlive = true, isFurry = true)
//
//            val mamList: List<Mammal> = listOf(mam1, mam2)
//
//            // List<Mammal> is a subType of List<Organism> and therefore we can do this
//            // this is called "covariance"
//            val orgList: List<Organism> = mamList
//            // in Java you aren't allowed to do this - that's called "invariance"
//
//            orgList.forEach { org ->
//                println("covarianceExample - orgList Name ${org.name}")
//                println("covarianceExample - orgList IsAlive? ${org.isAlive}")
//                // can't do this, this is a list of Organisms
//                //println("covarianceExample - orgList isFurry? ${org.isFurry}")
//            }
//
//        }
    }

}
