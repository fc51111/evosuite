/**
 * Copyright (C) 2010-2020 Gordon Fraser, Andrea Arcuri and EvoSuite
 * contributors
 *
 * This file is part of EvoSuite.
 *
 * EvoSuite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3.0 of the License, or
 * (at your option) any later version.
 *
 * EvoSuite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with EvoSuite. If not, see <http://www.gnu.org/licenses/>.
 */
package org.evosuite.symbolic.dse.algorithm;

import org.evosuite.Properties;
import org.evosuite.symbolic.dse.DSEStatistics;
import org.evosuite.symbolic.dse.algorithm.explorationalgorithms.SAGEExplorationAlgorithm;

/**
 * Factory of DSE Algorithms
 *
 * @author Ignacio Lebrero
 */
public class DSEAlgorithmFactory {
    private final static String DSE_ALGORITHM_TYPE_NOT_PROVIDED = "A DSE algorithm type must be provided";

    /** Statistics object for when creating a customized algorithm */
    private final DSEStatistics dseStatistics = DSEStatistics.getInstance();

    /** Should log the algorithm progress throughout it's execution */
    private final boolean showProgress = Properties.SHOW_PROGRESS;

    public ExplorationAlgorithm getDSEAlgorithm(DSEAlgorithms dseAlgorithmType) {
        if (dseAlgorithmType == null) {
            throw new IllegalArgumentException(DSE_ALGORITHM_TYPE_NOT_PROVIDED);
        }

        switch (dseAlgorithmType) {
            case SAGE:
                return new SAGEExplorationAlgorithm(dseStatistics, showProgress);
            default:
                throw new IllegalStateException("DSEAlgorithm not yet implemented: " + dseAlgorithmType.name());
        }
    }
}
