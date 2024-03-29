package com.example.timedeal.api;

import com.example.timedeal.dto.purchase.request.CreatePurchaseRequest;
import com.example.timedeal.service.purchase.PurchaseService;
import com.example.timedeal.utils.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping("/purchase")
    public ResponseResult<?> createPurchase(
            @RequestBody CreatePurchaseRequest request,
            @RequestHeader("Authentication") String requestHeader
    ){
        return new ResponseResult<>(purchaseService.purchase(request, requestHeader));
    }

    @GetMapping("/purchase/{userId}/user")
    public ResponseResult<?> productListByUser(@PathVariable Long userId){
        return new ResponseResult<>(purchaseService.productListByUser(userId));
    }

    @GetMapping("/purchase/{productId}/product")
    public ResponseResult<?> userListByProduct(@PathVariable Long productId){
        return new ResponseResult<>(purchaseService.userListByProduct(productId));
    }
}
