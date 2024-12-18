package com.example.contacts

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val company: String = "",
    val isAddingContact: Boolean = false,
    var hasCompany: Boolean =  false,
    val sortType: SortType = SortType.FIRST_NAME
)
