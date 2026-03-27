SUMMARY = "OCaml is a ML language implementation with a class-based object system."
HOMEPAGE = "https://https://github.com/ocaml/ocaml"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4f72f33f302a53dc329f4d3819fe14f9"

# Packages supported
# ocaml-native : Package built on build machine.
inherit native

# Parallel make does not work with some recipes
PARALLEL_MAKE = ""
PARALLEL_MAKEINST = ""

# Source repo
SRC_URI += "git://github.com/ocaml/ocaml;protocol=https;nobranch=1"
# SRC_URI += "file://0001-4.08.1-link-error.patch"
# SRC_URI += "file://0002-4.08.1-shebang-use-env.patch"
# SRC_URI += "file://0001-Fix-ocaml-compilation-in-ubuntu-22.04-LTS.patch"

PV = "5.4.1"
SRCREV = "152d7ca5dd2c67ecfece73f91aea5697f95178a5"

# S = "${WORKDIR}/ocaml-4.08.1"

do_configure () {
    ./configure --prefix="${prefix}" --enable-debugger=no --disable-ocamldoc --with-x=no
}

do_compile () {
    oe_runmake USRBINPATH="${USRBINPATH}" world.opt
}

do_install () {
    oe_runmake DESTDIR="${D}" install

    for s in `find "${D}${bindir}" -type f`; do
        sed -i -e "1s,#!.*ocamlrun.*,#!${USRBINPATH}/env ocamlrun," ${s}
    done
}
