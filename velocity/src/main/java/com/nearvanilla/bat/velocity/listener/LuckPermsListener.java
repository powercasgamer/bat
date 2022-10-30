package com.nearvanilla.bat.velocity.listener;

import com.google.inject.Inject;
import com.nearvanilla.bat.velocity.tab.TablistService;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import net.luckperms.api.event.user.UserDataRecalculateEvent;
import org.checkerframework.checker.nullness.qual.NonNull;

public class LuckPermsListener {

    private final @NonNull ProxyServer server;
    private final @NonNull TablistService tablistService;

    @Inject
    public LuckPermsListener(final @NonNull ProxyServer server,
                             final @NonNull TablistService tablistService) {
        this.server = server;
        this.tablistService = tablistService;
    }

    @Subscribe
    public void onGroupChange(final @NonNull UserDataRecalculateEvent event) {
        this.server.getPlayer(event.getUser().getUniqueId()).ifPresent(this.tablistService::handleServerConnection);
    }

}
