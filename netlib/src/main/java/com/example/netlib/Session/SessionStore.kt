package com.example.netlib.Session

class SessionStore {
    @Volatile var token: String? = null
        private set
    @Volatile var userId: String? = null
        private set

    fun save(token: String, userId: String) {
        this.token = token
        this.userId = userId
    }

    fun clear() {
        token = null
        userId = null
    }
}
