package com.example.nmd.service.banner;

import com.example.nmd.dto.request.CreateBanner;
import com.example.nmd.model.Banner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BannerService {
    Banner createBanner (CreateBanner createBanner);
    Banner updateBanner (CreateBanner createBanner);

    Banner deleteBanner(long id );
    List<Banner> getAllBannerByType(String type );
}
