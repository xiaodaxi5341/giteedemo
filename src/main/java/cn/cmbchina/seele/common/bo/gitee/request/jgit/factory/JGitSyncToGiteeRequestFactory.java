package cn.cmbchina.seele.common.bo.gitee.request.jgit.factory;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequestFactory;
import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.jgit.JGitSyncToGiteeRequest;

public class JGitSyncToGiteeRequestFactory extends SyncToGiteeRequestFactory {

    private volatile static JGitSyncToGiteeRequestFactory instance;

    private JGitSyncToGiteeRequestFactory() {

    }

    public static JGitSyncToGiteeRequestFactory getInstance() {
        if (instance == null) {
            synchronized (JGitSyncToGiteeRequestFactory.class) {
                if (instance == null) {
                    instance = new JGitSyncToGiteeRequestFactory();
                }
            }
        }
        return instance;
    }

    public JGitSyncToGiteeRequest getRequest(ExtraNecessaryInfo extraInfo) {
        return new JGitSyncToGiteeRequest();
    }
}