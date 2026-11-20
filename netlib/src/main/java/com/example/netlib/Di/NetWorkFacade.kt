package com.example.netlib.Di

import com.example.netlib.Client.IAuthClient
import com.example.netlib.Client.IGameClient
import com.example.netlib.Client.IProfileClient
import com.example.netlib.Session.SessionStore

data class NetworkFacade(
    val auth: IAuthClient,
    val profile: IProfileClient,
    val game: IGameClient,
    val session: SessionStore,
)