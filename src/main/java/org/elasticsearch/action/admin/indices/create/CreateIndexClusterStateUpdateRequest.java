/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.admin.indices.create;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.elasticsearch.cluster.ack.ClusterStateUpdateRequest;
import org.elasticsearch.cluster.block.ClusterBlock;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;

import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Cluster state update request that allows to create an index
 */
public class CreateIndexClusterStateUpdateRequest extends ClusterStateUpdateRequest<CreateIndexClusterStateUpdateRequest> {

    final String cause;
    final String index;

    private IndexMetaData.State state = IndexMetaData.State.OPEN;

    private Settings settings = ImmutableSettings.Builder.EMPTY_SETTINGS;

    private Map<String, String> mappings = Maps.newHashMap();

    private Map<String, IndexMetaData.Custom> customs = newHashMap();

    private Set<ClusterBlock> blocks = Sets.newHashSet();


    CreateIndexClusterStateUpdateRequest(String cause, String index) {
        this.cause = cause;
        this.index = index;
    }

    public CreateIndexClusterStateUpdateRequest settings(Settings settings) {
        this.settings = settings;
        return this;
    }

    public CreateIndexClusterStateUpdateRequest mappings(Map<String, String> mappings) {
        this.mappings.putAll(mappings);
        return this;
    }

    public CreateIndexClusterStateUpdateRequest customs(Map<String, IndexMetaData.Custom> customs) {
        this.customs.putAll(customs);
        return this;
    }

    public CreateIndexClusterStateUpdateRequest blocks(Set<ClusterBlock> blocks) {
        this.blocks.addAll(blocks);
        return this;
    }

    public CreateIndexClusterStateUpdateRequest state(IndexMetaData.State state) {
        this.state = state;
        return this;
    }

    public String cause() {
        return cause;
    }

    public String index() {
        return index;
    }

    public IndexMetaData.State state() {
        return state;
    }

    public Settings settings() {
        return settings;
    }

    public Map<String, String> mappings() {
        return mappings;
    }

    public Map<String, IndexMetaData.Custom> customs() {
        return customs;
    }

    public Set<ClusterBlock> blocks() {
        return blocks;
    }
}
