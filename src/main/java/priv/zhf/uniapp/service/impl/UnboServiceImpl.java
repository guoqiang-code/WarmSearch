package priv.zhf.uniapp.service.impl;

import priv.zhf.uniapp.entity.Unbo;
import priv.zhf.uniapp.mapper.UnboMapper;
import priv.zhf.uniapp.service.UnboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.zhf.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 首页轮播图 服务实现类
 * </p>
 */
@Service
public class UnboServiceImpl extends ServiceImpl<UnboMapper, Unbo> implements UnboService {

    @Override
    public MyPage searchUnbo(int pageNo, int limit, String idSorted, List<Unbo> Unbo) {
        MyPage page = null;
        List<Unbo> unbosList = new ArrayList<>();
        unbosList.addAll(Unbo);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(unbosList);
        }
        int total = unbosList.size();
        int maxPageNo = unbosList.size()%limit == 0? unbosList.size()/limit:unbosList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

//        page = new MyPage(unbosList.subList(beginIndex, endIndex), total);
        page = new MyPage(unbosList, total);

        return page;
    }
}
