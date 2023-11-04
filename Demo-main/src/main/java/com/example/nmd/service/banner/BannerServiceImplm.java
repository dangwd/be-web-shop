package com.example.nmd.service.banner;

import com.example.nmd.dto.request.CreateBanner;
import com.example.nmd.model.Banner;
import com.example.nmd.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImplm implements BannerService{
    private final BannerRepository  bannerRepository ;
    @Override
    public Banner createBanner(CreateBanner createBanner) {
        Banner banner = new Banner();
        banner.setImage(createBanner.getImage());
        banner.setTile(createBanner.getTitle());
        banner.setImage(createBanner.getImage());
        bannerRepository.save(banner);

        return banner;
    }

    @Override
    public Banner updateBanner(CreateBanner createBanner) {
        Optional<Banner> banner = bannerRepository.findById(createBanner.getId());
        if(!banner.isPresent()){
            throw new RuntimeException("Không tìm thấy ID");
        }

        banner.get().setType(createBanner.getType());
        banner.get().setTile(createBanner.getTitle());
        banner.get().setImage(createBanner.getImage());
        bannerRepository.save(banner.get());
        return banner.get();
    }

    @Override
    public Banner deleteBanner(long id) {
        Optional<Banner> banner = bannerRepository.findById(id);
        if(!banner.isPresent()){
            throw new RuntimeException("Không tìm thấy ID");
        }
        bannerRepository.delete(banner.get());
        return banner.get();
    }

    @Override
    public List<Banner> getAllBannerByType(String type) {
        return bannerRepository.findBannersByType(type);
    }
}
