/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.set.aphrodite.domain;

import java.net.URL;
import java.util.Date;
import java.util.regex.Pattern;

public class PullRequest {
    private static final Pattern UPGRADE_TITLE = Pattern.compile("\\s*Upgrade \\s*", Pattern.CASE_INSENSITIVE);

    private final String id;
    private final URL url;
    private final Codebase codebase;
    private PullRequestState state;
    private String title;
    private String body;
    private Repository repository;
    private boolean mergeable, merged, upgrade;
    private MergeableState mergableState;
    private Date mergedAt;

    public PullRequest(String id, URL url, Repository repository, Codebase codebase, PullRequestState state, String title, String body, boolean mergeable, boolean merged, MergeableState mergeableState, Date mergedAt) {
        this.id = id;
        this.url = url;
        this.codebase = codebase;
        this.state = state;
        this.title = title;
        this.body = body;
        this.repository = repository;
        this.mergeable = mergeable;
        this.merged = merged;
        this.mergedAt = mergedAt;
        if(this.title != null)
            this.upgrade = UPGRADE_TITLE.matcher(this.title).find();
    }

    public String getId() {
        return id;
    }

    public URL getURL() {
        return url;

    }

    public Codebase getCodebase() {
        return codebase;
    }

    public PullRequestState getState() {
        return state;
    }

    public void setState(PullRequestState state) {
        this.state = state;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PullRequest pullRequset = (PullRequest) o;

        return url.equals(pullRequset.url);

    }

    public boolean isMergeable() {
        return mergeable;
    }

    public boolean isMerged() {
        return merged;
    }

    public MergeableState getMergableState() {
        return mergableState;
    }

    public Date getMergedAt() {
        return mergedAt;
    }

    public boolean isUpgrade() {
        return upgrade;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PullRequest{" +
                "url=" + url +
                ", state=" + state +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", codebase=" + codebase +
                '}';
    }

}
