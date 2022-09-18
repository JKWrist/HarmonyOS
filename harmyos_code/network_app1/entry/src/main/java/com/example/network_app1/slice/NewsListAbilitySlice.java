/*
 * Copyright (c) 2021 Huawei Device Co., Ltd.
 * Licensed under the Apache License,Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.network_app1.slice;

import com.example.network_app1.NewsAbility;
import com.example.network_app1.ResourceTable;
import com.example.network_app1.bean.NewsInfo;
import com.example.network_app1.http.HttpReq;
import com.example.network_app1.provider.NewsListProvider;
import com.example.network_app1.utils.CommonUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * News list slice
 *
 * @since 2020-12-04
 */
public class NewsListAbilitySlice extends AbilitySlice
{
    private static final float FOCUS_TEXT_SIZE = 1.2f;
    private static final float UNFOCUSED_TEXT_SIZE = 1.0f;
    private Text selectText;

    private ListContainer newsListContainer;
    private ListContainer selectorListContainer;
    private List<NewsInfo> totalNewsDataList;
    private List<NewsInfo> newsDataList;

    private NewsListProvider newsListProvider;

    @Override
    public void onStart(Intent intent)
    {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_news_list_layout);
        initView();
        initData();
        initListener();
        newsListContainer.setItemProvider(newsListProvider);
        newsListProvider.notifyDataChanged();
    }

    private void initView()
    {
        newsListContainer = (ListContainer) findComponentById(ResourceTable.Id_news_container);
    }

    private void initData()
    {
        HttpReq h1 = new HttpReq(this, "http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html");
//        h1.getNews_json()
        Gson gson = new Gson();

       totalNewsDataList =
               gson.fromJson(
                       CommonUtils.getStringFromJsonPath(this, "entry/resources/rawfile/news_datas.json"),
                       new TypeToken<List<NewsInfo>>()
                       {
                       }.getType());
//         totalNewsDataList =
//                 gson.fromJson(
//                         h1.getNews_json(),
//                         new TypeToken<List<NewsInfo>>()
//                         {
//                         }.getType());

//        totalNewsDataList =
//                gson.fromJson(
//                        CommonUtils.getStringFromJsonPath(this, "entry/resources/rawfile/news_wangyi_data.json"),
//                        new TypeToken<NewsList>()
//                        {
//                        }.getType());

        newsDataList = new ArrayList<>();
        newsDataList.addAll(totalNewsDataList);

        // Provider
        newsListProvider = new NewsListProvider(newsDataList, this);
    }

    /**
     * init listener of news type and news detail
     */
    private void initListener()
    {
        newsListContainer.setItemClickedListener(
                (listContainer, component, position, id) ->
                {
                    Intent intent = new Intent();
                    Operation operation =
                            new Intent.OperationBuilder()
                                    .withBundleName(getBundleName())
                                    .withAbilityName(NewsAbility.class.getName())
                                    .withAction("action.detail")
                                    .build();
                    intent.setOperation(operation);
                    intent.setParam(NewsDetailAbilitySlice.INTENT_TITLE, newsDataList.get(position).getTitle());
                    intent.setParam(NewsDetailAbilitySlice.INTENT_READ, newsDataList.get(position).getReads());
                    intent.setParam(NewsDetailAbilitySlice.INTENT_LIKE, newsDataList.get(position).getLikes());
                    intent.setParam(NewsDetailAbilitySlice.INTENT_CONTENT, newsDataList.get(position).getContent());
                    intent.setParam(NewsDetailAbilitySlice.INTENT_IMAGE, newsDataList.get(position).getImgUrl());
                    startAbility(intent);
                });
    }


    private void updateListView()
    {
        newsListProvider.notifyDataChanged();
        newsListContainer.invalidate();
        newsListContainer.scrollToCenter(0);
    }

    @Override
    public void onActive()
    {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent)
    {
        super.onForeground(intent);
    }
}
