package team.kasta.bridaya.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingAndSorting {

    public static Pageable paging(PageAndSortModel model){

        Sort.Direction direct = null;

        if (StringUtils.isEmpty(model.getDirection())) {
            direct = Sort.Direction.ASC;
        }

        if (model.getDirection().equalsIgnoreCase("DESC")) {
            direct = Sort.Direction.DESC;
        }

        if (model.getDirection().equalsIgnoreCase("ASC")) {
            direct = Sort.Direction.ASC;
        }

        if (model.getPage() == 0) {
            model.setPage(0);
        }

        if (model.getSize() <= 0) {
            model.setSize(5);
        }

        return PageRequest.of(model.getPage(), model.getSize(), direct, model.getColumn());
    }
}
