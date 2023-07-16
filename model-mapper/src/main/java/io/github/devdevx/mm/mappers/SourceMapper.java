package io.github.devdevx.mm.mappers;

import io.github.devdevx.mm.dtos.SourceOne;
import io.github.devdevx.mm.dtos.TargetOne;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class SourceMapper {

    private ModelMapper flatterMapper = null;
    private ModelMapper partialUpdateMapper = null;

    public TargetOne flatter(SourceOne s) {
        return getFlatterMapper().map(s, TargetOne.class);
    }

    public TargetOne partialUpdate(SourceOne s, TargetOne t) {
        getPartialUpdateMapper().map(s, t);
        return t;
    }

    private ModelMapper getFlatterMapper() {
        if (flatterMapper != null) {
            return flatterMapper;
        }
        flatterMapper = new ModelMapper();
        flatterMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE); // For subfields
        return flatterMapper;
    }

    private ModelMapper getPartialUpdateMapper() {
        if (partialUpdateMapper != null) {
            return partialUpdateMapper;
        }
        partialUpdateMapper = new ModelMapper();
        partialUpdateMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE); // For subfields
        partialUpdateMapper
                .createTypeMap(SourceOne.class, TargetOne.class) // For ignored fields
                .addMappings(
                        m -> {
                            m.skip(TargetOne::setValueOne);
                            m.skip(TargetOne::setValueFour);
                        });
        return partialUpdateMapper;
    }
}
