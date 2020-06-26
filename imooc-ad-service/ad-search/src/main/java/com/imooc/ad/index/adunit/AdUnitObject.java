package com.imooc.ad.index.adunit;

import com.imooc.ad.index.adplan.AdPlanObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableServer.POA;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitObject {

    private Long unitId;
    private Integer unitStatus;
    private Integer positionType;
    private Long planId;

    private AdPlanObject adPlanObject;

    void update(AdUnitObject newObject){
        if(null != newObject.getUnitId()) {
            this.unitId = newObject.getUnitId();
        }
        if(null != newObject.getUnitStatus()) {
            this.unitId = newObject.getUnitId();
        }
        if(null != newObject.getPositionType()) {
            this.positionType = newObject.getPositionType();
        }
        if(null != newObject.getPlanId()) {
            this.planId = newObject.getPlanId();
        }
        if(null != newObject.getAdPlanObject()) {
            this.adPlanObject = newObject.getAdPlanObject();
        }
    }

    private static boolean isOpening(int positionType) {
        return (positionType & AdUnitConstants.POSITION_TYPE.OPENING) > 0;
    }

    private static boolean isCinema(int positionType) {
        return (positionType & AdUnitConstants.POSITION_TYPE.CINEMA) > 0;
    }

    private static boolean isCinemaMiddle(int positionType) {
        return (positionType & AdUnitConstants.POSITION_TYPE.CINAMA_MIDDLE) > 0;
    }

    private static boolean isCinemaPause(int positionType) {
        return (positionType & AdUnitConstants.POSITION_TYPE.CINAMA_PAUSE) > 0;
    }

    private static boolean isCinemaPost(int positionType) {
        return (positionType & AdUnitConstants.POSITION_TYPE.CINAME_POST) > 0;
    }

    public static boolean isAdSlotTypeOK(int adSlotType, int positionType) {

        switch (adSlotType) {
            case AdUnitConstants.POSITION_TYPE.OPENING:
                return isOpening(positionType);
            case AdUnitConstants.POSITION_TYPE.CINEMA:
                return isCinema(positionType);
            case AdUnitConstants.POSITION_TYPE.CINAMA_MIDDLE:
                return isCinemaMiddle(positionType);
            case AdUnitConstants.POSITION_TYPE.CINAMA_PAUSE:
                return isCinemaPause(positionType);
            case AdUnitConstants.POSITION_TYPE.CINAME_POST:
                return isCinemaPost(positionType);
            default:
                return false;
        }
    }
}
