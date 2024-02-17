package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

        //검증 오류 결과를 보관
//        Map<String, String> errors = new HashMap<>();

        //검증 로직
        if (!StringUtils.hasText(item.getItemName())) {
//           errors.put("itemName", "상품 이름은 필수입니다.");
//            bindingResult.addError(new FieldError("item", "itemName", "상품 이름은 필수입니다."));
//            bindingResult.addError(new FieldError("item", "itemName",item.getItemName(), false, new String[]{"required.item.itemName"}, null, "상품 이름은 필수입니다."));
            errors.rejectValue("itemName", "required");
        }

        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1_000_000) {
//            errors.put("price", "가격은 1,000 ~ 1,000,000 까지 허용합니다");
//            bindingResult.addError(new FieldError("item", "price", "가격은 1,000 ~ 1,000,000 까지 허용합니다"));
//            bindingResult.addError(new FieldError("item", "price", item.getPrice(), false, new String[]{"range.item.price"},new Object[]{"1,000", "1,000,000"} ,null));
            errors.rejectValue("price", "range");
        }

        if (item.getQuantity() == null || item.getQuantity() > 9999) {
//            errors.put("quantity", "수량은 최대 9,999 까지 허용합니다");
//            bindingResult.addError(new FieldError("item", "quantity", "수량은 최대 9,999 까지 허용합니다"));
            errors.rejectValue("quantity", "max");
        }

        // 특정 필드가 아닌 복합 룰 검증
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getPrice() * item.getQuantity();

            if (resultPrice < 10000) {
//                errors.put("globalError", "가격 * 수량의 합은 10,000원 이상이여야 합니다. 현재 값 = " + resultPrice);
//                bindingResult.addError(new ObjectError("item", "가격 * 수량의 합은 10,000원 이상이여야 합니다. 현재 값 ="+ resultPrice));
                errors.reject("totalPriceMain", new Object[]{10000, resultPrice}, null);

            }
        }

    }
}
