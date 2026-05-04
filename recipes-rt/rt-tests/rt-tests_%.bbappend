# Copyright (C) 2026 Savoir-faire Linux, Inc.
# SPDX-License-Identifier: Apache-2.0

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0001-cyclictest-add-lttng-tracepoint-for-latency-spikes.patch \
    "

DEPENDS:append = " lttng-ust"
