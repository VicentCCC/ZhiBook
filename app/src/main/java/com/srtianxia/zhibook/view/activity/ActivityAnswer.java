package com.srtianxia.zhibook.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.srtianxia.zhibook.R;
import com.srtianxia.zhibook.app.BaseActivity;
import com.srtianxia.zhibook.model.bean.zhibook.Answer;
import com.srtianxia.zhibook.presenter.GetAnswerPresenter;
import com.srtianxia.zhibook.view.IView.IActivityAnswer;
import com.srtianxia.zhibook.view.adapter.AnswerAdapter;
import com.srtianxia.zhibook.view.adapter.OnItemClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by srtianxia on 2016/2/10.
 */
public class ActivityAnswer extends BaseActivity implements IActivityAnswer {
    @Bind(R.id.tv_answer_answerCount)
    TextView tvAnswerAnswerCount;
    @Bind(R.id.rv_answer)
    RecyclerView rvAnswer;

    private AnswerAdapter adapter;
    private String questionId;
    private GetAnswerPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        questionId = getIntent().getStringExtra("questionId");
        ButterKnife.bind(this);
        initRv();
        presenter = new GetAnswerPresenter(this);
        presenter.getAnswer();
    }

    private void initRv() {
        adapter = new AnswerAdapter(this);
        rvAnswer.setAdapter(adapter);
        rvAnswer.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        });
    }

    @Override
    public String getQuestionId() {
        return questionId;
    }

    @Override
    public void initAnswerSuccess(List<Answer> answers) {
        adapter.setData(answers);
    }

    @Override
    public void initAnswerFailure(String s) {

    }
}
