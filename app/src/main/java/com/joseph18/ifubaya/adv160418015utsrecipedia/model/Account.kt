package com.joseph18.ifubaya.adv160418015utsrecipedia.model

class Account
    (
    var id: String,
    var name: String,
    var bio: String,
    var photoUrl: String,
) {

    companion object {

        fun getMockAccount(): Account {
            var account = Account(id = "user00", name = "User", bio = "I'm a new user!", photoUrl = "https://i.pravatar.cc/256?img=5")
            return account
        }
    }
}