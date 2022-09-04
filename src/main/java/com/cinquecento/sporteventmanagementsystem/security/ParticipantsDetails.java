package com.cinquecento.sporteventmanagementsystem.security;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ParticipantsDetails implements UserDetails {

    private final Participant participant;

    @Autowired
    public ParticipantsDetails(Participant participant) {
        this.participant = participant;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(participant.getRole()));
    }

    @Override
    public String getPassword() {
        return this.participant.getPassword();
    }

    @Override
    public String getUsername() {
        return this.participant.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Participant getParticipant() {
        return this.participant;
    }
}
