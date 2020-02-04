LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	  file://lld-disks.py \
          file://userparameter_diskstats.conf \
"
DEPENDS = "zabbix"

do_install_append() {
  install -m 0700 -d ${D}${sysconfdir}/zabbix_agentd.conf.d
  install -m 0644 ${WORKDIR}/userparameter_diskstats.conf ${D}${sysconfdir}/zabbix_agentd.conf.d/userparameter_diskstats.conf
  
  install -m 0755 -d ${D}{bindir}
  install -m 0644 ${bindir}/lld-disks.py  
}

FILES_${PN} = " \
	      ${sysconfdir}/zabbix_agentd.conf.d/userparameter_diskstats.conf \
              ${bindir}/lld-disks.py \
"

