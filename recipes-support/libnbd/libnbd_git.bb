# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYING.LIB
#   examples/LICENSE-FOR-EXAMPLES
#   golang/examples/LICENSE-FOR-EXAMPLES
#   ocaml/examples/LICENSE-FOR-EXAMPLES
#   python/examples/LICENSE-FOR-EXAMPLES
#   sh/examples/LICENSE-FOR-EXAMPLES
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "LGPL-2.1-only & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=13491c437f1f737d366322a97a7a1d96 \
                    file://examples/LICENSE-FOR-EXAMPLES;md5=642aab861aee55b1f009e35b7350534f \
                    file://golang/LICENSE;md5=4fbd65380cdd255951079008b364516c \
                    file://golang/examples/LICENSE-FOR-EXAMPLES;md5=1900b31814765d8ee1675b497a26c082 \
                    file://ocaml/examples/LICENSE-FOR-EXAMPLES;md5=dc19736c102bee1ab5e1dd39d7c83e27 \
                    file://python/examples/LICENSE-FOR-EXAMPLES;md5=499975ab3b1d53690119a63fac7c7489 \
                    file://sh/examples/LICENSE-FOR-EXAMPLES;md5=e39512c19f865cc78b367f7d688cae90"

SRC_URI = "git://gitlab.com/nbdkit/libnbd;protocol=https;branch=master"

# Modify these as desired
PV = "1.25.4+git"
SRCREV = "3cc807eabbaec7cb41d8799c333088c03a6fb719"

# NOTE: the following prog dependencies are unknown, ignoring: qemu-nbd cargo gtr truncate gnutls-certtool certtool dd tr go gtruncate gdd rustfmt grealpath nbdkit cmp nbd-server realpath cut gcmp psktool gnucut qemu-storage-daemon gofmt gstat stat
# NOTE: unable to map the following pkg-config dependencies: python-"$PYTHON_VERSION" libev ublksrv
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "gnutls glib-2.0 libxml2 fuse3 bash-completion ocamlbuild-native"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit python3native perlnative pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""
