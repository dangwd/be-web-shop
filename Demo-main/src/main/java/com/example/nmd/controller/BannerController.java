package com.example.nmd.controller;

import com.example.nmd.dto.request.CreateBanner;
import com.example.nmd.dto.response.BaseResponse;
import com.example.nmd.service.banner.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("banner/")
@RequiredArgsConstructor
public class BannerController {
    private final BannerService bannerService ;
    @PostMapping("create")
    public BaseResponse createBanner(@RequestBody CreateBanner createBanner){
        return  BaseResponse.successData(bannerService.createBanner(createBanner));
    }

    @PostMapping("update")
    public BaseResponse updateBanner (@RequestBody CreateBanner createBanner){
        return BaseResponse.successData(bannerService.updateBanner(createBanner));
    }

    @GetMapping("{type}")
    public BaseResponse getByID (@PathVariable String type){
        return  BaseResponse.successListData(bannerService.getAllBannerByType(type) , bannerService.getAllBannerByType(type).size());
    }
    @DeleteMapping("del/{id}")
    public BaseResponse deleteByOd (@PathVariable long id){
        return BaseResponse.successData(bannerService.deleteBanner(id));
    }
}
